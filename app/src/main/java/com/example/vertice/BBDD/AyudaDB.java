package com.example.vertice.BBDD;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import static com.example.vertice.BBDD.StudyWorldBBDD.BD_CREATE_ALUMNOS;
import static com.example.vertice.BBDD.StudyWorldBBDD.BD_CREATE_ASIGNATURAS;
import static com.example.vertice.BBDD.StudyWorldBBDD.TABLA_ALUMNOS;
import static com.example.vertice.BBDD.StudyWorldBBDD.TABLA_ASIGNATURAS;
import static com.example.vertice.BBDD.StudyWorldBBDD.TAG;
import static com.example.vertice.BBDD.StudyWorldBBDD.NOMBRE_BD;
import static com.example.vertice.BBDD.StudyWorldBBDD.VERSIO;

public class AyudaDB extends SQLiteOpenHelper
{
    AyudaDB(Context context)
    {
        super(context,NOMBRE_BD, null, VERSIO);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(BD_CREATE_ALUMNOS);
            db.execSQL(BD_CREATE_ASIGNATURAS);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(TAG, "Actualizando base de datos de la versión: " + oldVersion + " a la versión: "+ newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ALUMNOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ASIGNATURAS);
        onCreate(db);
    }
}
