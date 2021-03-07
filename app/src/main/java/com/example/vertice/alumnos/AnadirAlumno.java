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
    // Creamos los botones y los campos de texto que usaremos para añadir alumnos
    private StudyWorldBBDD db;
    private EditText editName, editEdad, editEmail, editCurso;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);

        editName = findViewById(R.id.editCalificarIDAsignatura);
        editEdad = findViewById(R.id.editNota);
        editEmail = findViewById(R.id.editRefreshEmailAlumno);
        editCurso= findViewById(R.id.editRefreshCursoAlumno);
        editName = findViewById(R.id.editCalificarIDAsignatura);

        addButton = findViewById(R.id.addNuevaAsignatura);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores para evitar que el usuario introduzca datos vacios en la bdd
                // Decdimos que un alumno puede estar en la bdd sin tener el curso adjudicado.
                if (editName.getText().toString().equals("") || editEdad.getText().toString().equals("") || editEmail.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes meter valores vacios en la base de datos", Toast.LENGTH_SHORT).show();
                    finish();
                }
                // Si el usario mete datos con contendio seguimos con el programa y metemos los datos del alumno en la base de datos.
                else {
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
            }
        });
    }
}