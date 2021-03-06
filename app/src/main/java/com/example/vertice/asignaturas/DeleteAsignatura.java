package com.example.vertice.asignaturas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

public class DeleteAsignatura extends AppCompatActivity
{
    StudyWorldBBDD db;
    Button deleteAsignaturaButton;
    EditText editTextAsignaturaIDdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_asignatura);

        deleteAsignaturaButton = findViewById(R.id.deleteAsignaturaButtoncito);
        editTextAsignaturaIDdelete = findViewById(R.id.editTextAsignaturaIDdelete);

        deleteAsignaturaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores del usuario: El usuario puede meter asignaturas sin el campo horas.
                if (editTextAsignaturaIDdelete.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes borrar un asignatura sin especificaar su id", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    db = new StudyWorldBBDD(getApplicationContext());
                    db.obre();

                    long id = Long.parseLong(editTextAsignaturaIDdelete.getText().toString());
                    boolean result = db.borrarAsignatura(id);

                    if(result)
                    {
                        Toast.makeText(getApplicationContext(), "Asignatura eliminada", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No se ha podido eliminar la asignatura", Toast.LENGTH_SHORT).show();
                    }
                    db.tanca();
                    finish();
                }
            }
        });
    }
}