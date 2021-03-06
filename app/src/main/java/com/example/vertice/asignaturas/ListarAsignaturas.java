package com.example.vertice.asignaturas;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

import java.util.ArrayList;
import java.util.HashMap;


public class ListarAsignaturas extends ListActivity
{
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        listaAsignaturas();
    }

    public void listaAsignaturas()
    {
        StudyWorldBBDD db;
        db = new StudyWorldBBDD(this);
        db.obre();
        Cursor c = db.obtenerTodasLasAsignaturas();
        c.moveToFirst();
        ArrayList<HashMap<String, String>> llista =  new ArrayList<HashMap<String, String>>();
        while(!c.isAfterLast())
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id_A", c.getString(0));
            map.put("nom_A", c.getString(1));
            map.put("horas", c.getString(2));
            llista.add(map);
            c.moveToNext();
        }
        db.tanca();
        adapter = new SimpleAdapter(this, llista, R.layout.activity_listar_asignaturas, new String[]{"id_A", "nom_A", "horas"}, new int[]{R.id.tvAsignaturaID, R.id.tvAsignaturaNombre, R.id.tvAsignaturaHoras});
        setListAdapter(adapter);
    }
}