package com.example.vertice.asignaturas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;


public class AnadirAsignatura extends AppCompatActivity
{
    // Creamos las variables que utilizaremos para añdir asignaturas
    private StudyWorldBBDD db;
    private EditText editNombreAsignatura, editHorasAsignatura;
    private Button addAsignaturaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_asignatura);

        editNombreAsignatura = findViewById(R.id.editCalificarIDAsignatura);
        editHorasAsignatura = findViewById(R.id.editHorasAsignatura);
        addAsignaturaButton = findViewById(R.id.addNuevaAsignatura);

        addAsignaturaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores del usuario: El usuario puede meter asignaturas sin el campo horas.
                if (editNombreAsignatura.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes meter valores vacios en la base de datos", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    db = new StudyWorldBBDD(getApplicationContext());
                    db.obre();
                    if(db.añadirAsignaturas(editNombreAsignatura.getText().toString(), editHorasAsignatura.getText().toString()) != -1)
                    {
                        Toast.makeText(getApplicationContext(), "Asignatura añadida correctamente", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Fallo al añadir asignatura", Toast.LENGTH_SHORT).show();
                    }
                    db.tanca();
                    finish();
                }
            }
        });
    }
}