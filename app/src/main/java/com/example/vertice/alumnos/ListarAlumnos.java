package com.example.vertice.alumnos;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

import java.util.ArrayList;
import java.util.HashMap;


public class ListarAlumnos extends ListActivity
{
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        listaAlumnos();
    }

    public void listaAlumnos()
    {
        StudyWorldBBDD db;
        db = new StudyWorldBBDD(this);
        db.obre();
        Cursor c = db.obtenerTodosLosAlumnos();
        c.moveToFirst();
        ArrayList<HashMap<String, String>> llista =  new ArrayList<HashMap<String, String>>();
        while(!c.isAfterLast())
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", c.getString(0));
            map.put("nom", c.getString(1));
            map.put("edad", c.getString(2));
            map.put("email", c.getString(3));
            map.put("curso", c.getString(4));
            llista.add(map);
            c.moveToNext();
        }
        db.tanca();
        adapter = new SimpleAdapter(this, llista, R.layout.activity_listar_alumnos, new String[]{"id", "nom", "edad", "email", "curso"}, new int[]{R.id.tvAsignaturaID, R.id.tvAsignaturaNombre, R.id.tvAsignaturaHoras, R.id.textViewEMAIL, R.id.textViewCurso});
        setListAdapter(adapter);
    }
}