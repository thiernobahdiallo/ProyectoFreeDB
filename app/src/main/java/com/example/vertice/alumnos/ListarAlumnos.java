package com.example.vertice.alumnos;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;
import com.example.vertice.adapter.AlumnoAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class ListarAlumnos extends AppCompatActivity
{
    StudyWorldBBDD db;
    private RecyclerView rv;
    private AlumnoAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alumnos);
        rv = findViewById(R.id.Recycler);
        listaAlumnos();
    }

    public void listaAlumnos()
    {
        db = new StudyWorldBBDD(this);
        db.obre();

        ArrayList<Estudiante> estudiantes = db.getAllEstudiantes();
        Adapter = new AlumnoAdapter(this, estudiantes);
        Log.d("errorrrr", String.valueOf(estudiantes));
        db.tanca();

        rv.setAdapter(Adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}