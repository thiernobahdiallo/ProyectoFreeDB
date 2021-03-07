package com.example.vertice.asignaturas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

public class ModificarAsignatura extends AppCompatActivity
{
    StudyWorldBBDD db;
    Button actualizarAsignatura;

    private EditText editAsignaturaId, editNombreAsignatura, editAsignaturaHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_asignatura);

        actualizarAsignatura = findViewById(R.id.calificarButton);
        editAsignaturaId = findViewById(R.id.editCalificarIdAlumno);
        editNombreAsignatura = findViewById(R.id.editCalificarIDAsignatura);
        editAsignaturaHoras = findViewById(R.id.editNota);

        actualizarAsignatura.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores del usuario: El usuario puede modificar asignaturas sin el campo horas.
                if (editAsignaturaId.getText().toString().equals("") || editNombreAsignatura.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes modificar un asignatura sin especificaar su id", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    long id;
                    db = new StudyWorldBBDD(getApplicationContext());
                    db.obre();
                    id = Long.parseLong(editAsignaturaId.getText().toString());
                    boolean result = db.actualizarAsignatura(id,editNombreAsignatura.getText().toString(), editAsignaturaHoras.getText().toString());
                    if(result)
                    {
                        Toast.makeText(getApplicationContext(), "Asignatura modificada", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No se ha podido modificar la asignatura", Toast.LENGTH_SHORT).show();
                        db.tanca();
                        finish();
                    }
                }
            }
        });
    }
}