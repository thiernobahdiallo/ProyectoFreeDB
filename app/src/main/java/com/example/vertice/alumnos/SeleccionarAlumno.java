package com.example.vertice.alumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

public class SeleccionarAlumno extends AppCompatActivity implements View.OnClickListener
{
    private StudyWorldBBDD db;
    private EditText editId;
    private TextView name, email;
    private Button selectButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_alumno);

        selectButton = findViewById(R.id.selectButtoncito);
        backButton = findViewById(R.id.backButton);

        editId = findViewById(R.id.editId);

        name = findViewById(R.id.textViewName);
        email = findViewById(R.id.textViewEmail);

        selectButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == selectButton)
        {
            Cursor c;
            db = new StudyWorldBBDD(this.getApplicationContext());
            db.obre();
            long id = Long.parseLong(editId.getText().toString());
            c = db.obtenerAlumno(id);
            if(c.getCount() != 0)
            {
                name.setText(c.getString(1));
                email.setText(c.getString(2));
                Toast.makeText(this, "Element con id: " + c.getString(0) + " consultado correctamente.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "ID inexistente ",Toast.LENGTH_SHORT).show();
            }
            db.tanca();
        }
        else if(v == backButton)
        {
            finish();
        }
    }
}