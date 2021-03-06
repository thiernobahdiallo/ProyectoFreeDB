package com.example.vertice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vertice.alumnos.DeleteAlumno;
import com.example.vertice.alumnos.ListarAlumnos;
import com.example.vertice.alumnos.ModificarAlumno;
import com.example.vertice.alumnos.SeleccionarAlumno;
import com.example.vertice.alumnos.AnadirAlumno;

public class Alumno extends AppCompatActivity implements View.OnClickListener
{
    Button addAlumnoButton, selectAlumnoButton, listAlumnoButton, modificarAlumnoButton, deleteAlumnoButton, moveToAsignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        addAlumnoButton = findViewById(R.id.añadirAlumnoButton);
        addAlumnoButton.setOnClickListener(this);

        selectAlumnoButton = findViewById(R.id.selectAlumnoButton);
        selectAlumnoButton.setOnClickListener(this);

        listAlumnoButton = findViewById(R.id.listAlumnoButton);
        listAlumnoButton.setOnClickListener(this);

        modificarAlumnoButton = findViewById(R.id.modificarAlumnoButton);
        modificarAlumnoButton.setOnClickListener(this);

        deleteAlumnoButton = findViewById(R.id.deleteAlumnoButton);
        deleteAlumnoButton.setOnClickListener(this);

        moveToAsignaturas = findViewById(R.id.moveToAsignaturas);
        moveToAsignaturas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == addAlumnoButton)
        {
            startActivity(new Intent(v.getContext(), AnadirAlumno.class));
        }
        else if(v == selectAlumnoButton)
        {
            startActivity(new Intent(v.getContext(), SeleccionarAlumno.class));
        }
        else if(v == listAlumnoButton)
        {
            startActivity(new Intent(v.getContext(), ListarAlumnos.class));
        }
        else if(v == modificarAlumnoButton)
        {
            startActivity(new Intent(v.getContext(), ModificarAlumno.class));
        }
        else if(v == deleteAlumnoButton)
        {
            startActivity(new Intent(v.getContext(), DeleteAlumno.class));
        }
        else if(v == moveToAsignaturas)
        {
            startActivity(new Intent(v.getContext(), Asignatura.class));
        }
    }
}