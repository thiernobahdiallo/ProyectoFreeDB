package com.example.vertice.alumnos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;


public class CalificarAlumno extends AppCompatActivity
{
    private StudyWorldBBDD db;
    private EditText editIDAlumno, editIDAsignatura, editNota;
    private Button calificarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar_alumno);

        editIDAlumno = findViewById(R.id.editCalificarIdAlumno);
        editIDAsignatura = findViewById(R.id.editCalificarIDAsignatura);
        editNota = findViewById(R.id.editNota);

        calificarButton = findViewById(R.id.calificarButton);
        calificarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores del usuario: El alumno no puede ser calificado sin especificar el id del alumno, el de asignatura y la nota.
                if (editIDAlumno.getText().toString().equals("") || editIDAsignatura.getText().toString().equals("") || editNota.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes calificar un alumno sin especificar los id's", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    db = new StudyWorldBBDD(getApplicationContext());
                    db.obre();
                    if(db.anadirNotas(editIDAlumno.getText().toString(), editIDAsignatura.getText().toString(), editNota.getText().toString()) != -1)
                    {
                        Toast.makeText(getApplicationContext(), "Nota añadida correctamente", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "FALLO AL AÑADIR nota", Toast.LENGTH_SHORT).show();
                    }
                    db.tanca();
                    finish();
                }
            }
        });
    }
}