package com.example.vertice.asignaturas;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

public class SeleccionarAsignatura extends AppCompatActivity implements View.OnClickListener
{
    private StudyWorldBBDD db;
    private EditText editAsignaturaId;
    private TextView nombreAsignatura, nombreAsignaturha, horasAsignatura, horasAsignaturha;
    private Button selectAsignaturaButton, backAsignaturaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_asignatura);

        selectAsignaturaButton = findViewById(R.id.selectAsignaturaButtoncito);
        backAsignaturaButton = findViewById(R.id.backAsignaturaButton);

        editAsignaturaId = findViewById(R.id.editAsignaturaID);

        nombreAsignatura = findViewById(R.id.tvSelectNombreAsignatura);
        nombreAsignaturha = findViewById(R.id.tvSelectNombreAsignaturha);

        horasAsignatura = findViewById(R.id.tvSelectHorasAsignatura);
        horasAsignaturha = findViewById(R.id.tvSelectHorasAsignaturha);

        selectAsignaturaButton.setOnClickListener(this);
        backAsignaturaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // Aqui hacemos un control de errores del usuario: El usuario puede modificar asignaturas sin el campo horas.
        if (editAsignaturaId.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "No puedes seleccionar una asignatura sin especificar su id", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            if(v == selectAsignaturaButton)
            {
                Cursor c;
                db = new StudyWorldBBDD(this.getApplicationContext());
                db.obre();
                long id = Long.parseLong(editAsignaturaId.getText().toString());
                c = db.obtenerAsignatura(id);

                if(c.getCount() != 0)
                {
                    nombreAsignaturha.setText(c.getString(1));
                    horasAsignaturha.setText(c.getString(2));
                    Toast.makeText(this, "Asignatura con id: " + c.getString(0) + " consultada correctamente.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "ID inexistentee ",Toast.LENGTH_SHORT).show();
                }
                db.tanca();
            }
            else if(v == backAsignaturaButton)
            {
                finish();
            }
        }
    }
}