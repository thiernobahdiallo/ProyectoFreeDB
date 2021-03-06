package com.example.vertice.BBDD;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import static com.example.vertice.BBDD.VerticeBBDD.BD_CREATE_ALUMNOS;
import static com.example.vertice.BBDD.VerticeBBDD.BD_CREATE_ASIGNATURAS;
import static com.example.vertice.BBDD.VerticeBBDD.TABLA_ALUMNOS;
import static com.example.vertice.BBDD.VerticeBBDD.TABLA_ASIGNATURAS;
import static com.example.vertice.BBDD.VerticeBBDD.TAG;
import static com.example.vertice.BBDD.VerticeBBDD.NOMBRE_BD;
import static com.example.vertice.BBDD.VerticeBBDD.VERSIO;

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
