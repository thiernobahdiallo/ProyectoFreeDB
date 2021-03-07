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
    private EditText editAlumnoID;
    private TextView nombreAlumno, nombreAlumnho, edadAlumno, edadAlumnho, emailAlumno, emailAlumnho, cursoAlumno, cursoAlumnho;
    private Button selectButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_alumno);

        selectButton = findViewById(R.id.selectAsignaturaButtoncito);
        backButton = findViewById(R.id.backAsignaturaButton);

        editAlumnoID = findViewById(R.id.editAsignaturaID);

        nombreAlumno = findViewById(R.id.tvSelectNombreAsignatura);
        nombreAlumnho = findViewById(R.id.tvNombreAlumnho);

        edadAlumno = findViewById(R.id.tvEdadAlumno);
        edadAlumnho = findViewById(R.id.tvEdadAlumnho);

        emailAlumno = findViewById(R.id.tvEmailAlumno);
        emailAlumnho = findViewById(R.id.tvEmailAlumnho);

        cursoAlumno = findViewById(R.id.tvCursoAlumno);
        cursoAlumnho = findViewById(R.id.tvCursoAlumnho);

        selectButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == selectButton)
        {
            // Aqui hacemos un control de errores para evitar que el usuario introduzca datos vacios en la bdd
            if (editAlumnoID.getText().toString().equals(""))
            {
                Toast.makeText(getApplicationContext(), "No puedes meter valores vacios en la base de datos", Toast.LENGTH_SHORT).show();
                finish();
            }
            // Si el usario mete datos con contendio seguimos con el programa y metemos los datos del alumno en la base de datos.
            else
                {
                    Cursor c;
                    db = new StudyWorldBBDD(this.getApplicationContext());
                    db.obre();
                    long id = Long.parseLong(editAlumnoID.getText().toString());
                    c = db.obtenerAlumno(id);
                    if(c.getCount() != 0)
                    {
                        nombreAlumnho.setText(c.getString(1));
                        edadAlumnho.setText(c.getString(2));
                        emailAlumnho.setText(c.getString(3));
                        cursoAlumnho.setText(c.getString(4));
                        Toast.makeText(this, "Element con id: " + c.getString(0) + " consultado correctamente.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, "ID inexistente ",Toast.LENGTH_SHORT).show();
                    }
                    db.tanca();
            }
        }
        else if(v == backButton)
        {
            finish();
        }
    }
}