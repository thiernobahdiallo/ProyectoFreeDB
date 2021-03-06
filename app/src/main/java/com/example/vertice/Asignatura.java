package com.example.vertice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vertice.alumnos.SeleccionarAlumno;
import com.example.vertice.asignaturas.AnadirAsignatura;
import com.example.vertice.asignaturas.DeleteAsignatura;
import com.example.vertice.asignaturas.ListarAsignaturas;
import com.example.vertice.asignaturas.ModificarAsignatura;
import com.example.vertice.asignaturas.SeleccionarAsignatura;

public class Asignatura extends AppCompatActivity implements View.OnClickListener
{
    Button addAsignaturaButton, selectAsignaturaButton, listAsignaturaButton, modificarAsignaturaButton, deleteAsignaturaButton, moveToAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);

        addAsignaturaButton = findViewById(R.id.añadirAsignaturaButton);
        addAsignaturaButton.setOnClickListener(this);

        selectAsignaturaButton = findViewById(R.id.selectAsignaturaButtoncito);
        selectAsignaturaButton.setOnClickListener(this);

        listAsignaturaButton = findViewById(R.id.listAsignaturaButton);
        listAsignaturaButton.setOnClickListener(this);

        modificarAsignaturaButton = findViewById(R.id.modificarAsignaturaButton);
        modificarAsignaturaButton.setOnClickListener(this);

        deleteAsignaturaButton = findViewById(R.id.deleteAsignaturaButton);
        deleteAsignaturaButton.setOnClickListener(this);

        moveToAlumnos = findViewById(R.id.moveToAlumnos);
        moveToAlumnos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == addAsignaturaButton)
        {
            startActivity(new Intent(v.getContext(), AnadirAsignatura.class));
        }
        else if(v == selectAsignaturaButton)
        {
            startActivity(new Intent(v.getContext(), SeleccionarAsignatura.class));
        }
        else if(v == listAsignaturaButton)
        {
            startActivity(new Intent(v.getContext(), ListarAsignaturas.class));
        }
        else if(v == modificarAsignaturaButton)
        {
            startActivity(new Intent(v.getContext(), ModificarAsignatura.class));
        }
        else if(v == deleteAsignaturaButton)
        {
            startActivity(new Intent(v.getContext(), DeleteAsignatura.class));
        }
        else if(v == moveToAlumnos)
        {
           startActivity(new Intent(v.getContext(), Alumno.class));
        }
    }
}