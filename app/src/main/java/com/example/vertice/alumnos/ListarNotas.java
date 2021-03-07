package com.example.vertice.alumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListarNotas  extends ListActivity {

    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        listarNotas();
    }

    public void listarNotas()
    {
        StudyWorldBBDD db;
        db = new StudyWorldBBDD(this);
        db.obre();
        Cursor c = db.obtenerNotas();
        c.moveToFirst();
        ArrayList<HashMap<String, String>> llista =  new ArrayList<HashMap<String, String>>();
        while(!c.isAfterLast())
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("nombre", c.getString(0));
            map.put("nombreAsig", c.getString(1));
            map.put("nota", c.getString(2));
            llista.add(map);
            c.moveToNext();
        }
        db.tanca();
        adapter = new SimpleAdapter(this, llista, R.layout.activity_listar_notas, new String[]{"nombre", "nombreAsig", "nota"}, new int[]{R.id.tvNombreAlumnoNotas, R.id.tvAsignaturaNombreNotas, R.id.tvNota});
        setListAdapter(adapter);
    }
}