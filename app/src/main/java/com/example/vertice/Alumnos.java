package com.example.vertice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vertice.BBDD.AnadirAlumnos;
import com.example.vertice.BBDD.DeleteAlumno;
import com.example.vertice.BBDD.ListarAlumnos;
import com.example.vertice.BBDD.ModificarAlumno;
import com.example.vertice.BBDD.SeleccionarAlumno;

public class Alumnos extends AppCompatActivity implements View.OnClickListener{
    Button anadirButton, selectButton, listButton, modfificarButton, deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        anadirButton = findViewById(R.id.añadirButton);
        anadirButton.setOnClickListener(this);

        selectButton = findViewById(R.id.selectButton);
        selectButton.setOnClickListener(this);

        listButton = findViewById(R.id.listButton);
        listButton.setOnClickListener(this);

        modfificarButton = findViewById(R.id.modificarButton);
        modfificarButton.setOnClickListener(this);

        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == anadirButton)
        {
            startActivity(new Intent(v.getContext(), AnadirAlumnos.class));
        }
        else if(v == selectButton)
        {
            startActivity(new Intent(v.getContext(), SeleccionarAlumno.class));
        }
        else if(v == listButton)
        {
            startActivity(new Intent(v.getContext(), ListarAlumnos.class));
        }
        else if(v == modfificarButton)
        {
            startActivity(new Intent(v.getContext(), ModificarAlumno.class));
        }
        else if(v == deleteButton)
        {
            startActivity(new Intent(v.getContext(), DeleteAlumno.class));
        }
    }
}