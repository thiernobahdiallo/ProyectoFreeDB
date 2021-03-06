package com.example.vertice.alumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;


public class AnadirAlumno extends AppCompatActivity
{
    private StudyWorldBBDD db;
    private EditText editName, editEdad,editEmail,editCurso;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);

        editName = findViewById(R.id.editNombreAsignatura);
        editEdad = findViewById(R.id.editEdad);
        editEmail = findViewById(R.id.editEmail);
        editCurso= findViewById(R.id.editCurso);
        editName = findViewById(R.id.editNombreAsignatura);

        addButton = findViewById(R.id.addNuevaAsignatura);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db = new StudyWorldBBDD(getApplicationContext());
                db.obre();
                if(db.añadirAlumno(editName.getText().toString(), editEdad.getText().toString(), editEmail.getText().toString(), editCurso.getText().toString()) != -1)
                {
                    Toast.makeText(getApplicationContext(), "Añadido correctamente", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "FALLO AL AÑADIR", Toast.LENGTH_SHORT).show();
                }
                db.tanca();
                finish();
            }
        });
    }
}