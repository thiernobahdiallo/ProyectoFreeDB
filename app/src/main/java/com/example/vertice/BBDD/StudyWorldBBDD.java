package com.example.vertice.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.vertice.alumnos.Estudiante;

import java.util.ArrayList;


public class StudyWorldBBDD
{
    // Creamos las tablas de la base de datos.
    // La primera tabla es la tabla ALUMNOS.
    public static final String NOMBRE_BD = "StudyWorld";
    public static final String TAG = "DBInterface";
    public static final String TABLA_ALUMNOS = "alumnos";
    public static final String ID_ALUMNO = "id";
    public static final String NOMBRE_ALUMNO = "nom";
    public static final String EDAD_ALUMNO = "edad";
    public static final String EMAIL_ALUMNO = "email";
    public static final String CLAU_FOTO = "foto";
    public static final String CURSO_ALUMNO = "curso";
    public static final String BD_CREATE_ALUMNOS = "create table " + TABLA_ALUMNOS
            + " ( "
            + ID_ALUMNO + " integer primary key autoincrement, "
            + NOMBRE_ALUMNO + " TEXT NOT NULL, "
            + EDAD_ALUMNO + " integer NOT NULL, "
            + EMAIL_ALUMNO + " TEXT , "
            + CLAU_FOTO + " BLOB, "
            + CURSO_ALUMNO + " TEXT NOT NULL);";

    // ------------------------------------------------------------
    // La segunda tabla de nuestra base de datos será asignaturas.
    public static final String TABLA_ASIGNATURAS = "asignaturas";
    public static final String ID_ASIGNATURA = "id_A";
    public static final String NOMBRE_ASIGNATURA ="nom_A";
    public static final String HORAS = "horas";
    public static final String BD_CREATE_ASIGNATURAS = "create table " + TABLA_ASIGNATURAS
            + " ( "
            + ID_ASIGNATURA + " integer primary key autoincrement, "
            + NOMBRE_ASIGNATURA + " TEXT NOT NULL, "
            + HORAS + " integer NOT NULL);";

    // -------------------------------------------------------------
    // Como las dos tablas tienen una relación N - N hay que crear
    // una tabla intermedia que haga de relación entre dichas tablas.
    public static final String TABLA_CURSAR = "cursar";
    public static final String ID_ASIGNATURA_CURSADA = "id_Asig_Curso";
    public static final String ID_ALUMNO_CURSANDO = "id_Alumn_Curso";
    public static final String NOTA_ALUMNO = "nota";
    public static final String BD_CREATE_CURSAR = "create table " + TABLA_CURSAR
            +" ( "
            + NOTA_ALUMNO + " integer NOT NULL, "
            + ID_ALUMNO_CURSANDO + " integer NOT NULL, "
            + ID_ASIGNATURA_CURSADA + " integer NOT NULL, "
            + "FOREIGN KEY ("+ ID_ALUMNO_CURSANDO +") REFERENCES " + TABLA_ALUMNOS +
            "(" + ID_ALUMNO + ")"
            +  ", FOREIGN KEY ("+ ID_ASIGNATURA_CURSADA +") REFERENCES " + TABLA_ASIGNATURAS +
            "(" + ID_ASIGNATURA + ")" +
            " PRIMARY KEY (" + ID_ASIGNATURA_CURSADA + ", " + ID_ALUMNO_CURSANDO + ")" +
            ")";
    public static final int VERSIO = 1;
    private final Context context;
    private AyudaDB ayuda;
    private SQLiteDatabase db;

    public StudyWorldBBDD(Context context)
    {
        this.context = context;
        ayuda = new AyudaDB(context);
    }

    public StudyWorldBBDD obre() throws SQLException
    {
        db = ayuda.getWritableDatabase();
        return this;
    }

    public void tanca()
    {
        ayuda.close();
    }

    // Métodos para AÑADIR un elemento a la base de datos.
    public long añadirAlumno(String nombre, String edad, String email, String curso)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NOMBRE_ALUMNO, nombre);
        initialValues.put(EDAD_ALUMNO, edad);
        initialValues.put(EMAIL_ALUMNO, email);
        initialValues.put(CURSO_ALUMNO, curso);
        //initialValues.put(CLAU_FOTO,foto);
        return db.insert(TABLA_ALUMNOS, null, initialValues);
    }

    public long añadirAsignaturas(String nombre, String horas)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NOMBRE_ASIGNATURA, nombre);
        initialValues.put(HORAS, horas);
        return db.insert(TABLA_ASIGNATURAS, null, initialValues);
    }

    public long anadirNotas(String idAsignatura, String idAlumno, String nota)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(ID_ALUMNO_CURSANDO, idAlumno);
        initialValues.put(ID_ASIGNATURA_CURSADA, idAsignatura);
        initialValues.put(NOTA_ALUMNO, nota);
        return db.insert(TABLA_CURSAR, null, initialValues);
    }
    // -------------------------------------------------------

    // Métodos para ELIMINAR un registro de la base de datos.
    public boolean borrarAlumno(long IDFila)
    {
        return db.delete(TABLA_ALUMNOS, ID_ALUMNO + " = " + IDFila, null) > 0;
    }

    public boolean borrarAsignatura(long IDFila)
    {
        return db.delete(TABLA_ASIGNATURAS, ID_ASIGNATURA + " = " + IDFila, null) > 0;
    }
    // -------------------------------------------------------

    // Métodos para hacer un SELECT a un registro de la base de datos.
    public Cursor obtenerAlumno(long IDFila) throws SQLException
    {
        Cursor mCursor = db.query(true, TABLA_ALUMNOS, new String[] {ID_ALUMNO, NOMBRE_ALUMNO, EDAD_ALUMNO, EMAIL_ALUMNO, CURSO_ALUMNO}, ID_ALUMNO + " = " + IDFila, null, null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor obtenerAsignatura(long IDFila) throws SQLException
    {
        Cursor mCursor = db.query(true, TABLA_ASIGNATURAS, new String[] {ID_ASIGNATURA, NOMBRE_ASIGNATURA, HORAS}, ID_ASIGNATURA + " = " + IDFila, null, null, null, null, null);
        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    // -------------------------------------------------------

    // Métodos para LISTAR todos los registros de la tabla.
    public Cursor obtenerTodosLosAlumnos()
    {
        return db.query(TABLA_ALUMNOS, new String[]{ID_ALUMNO, NOMBRE_ALUMNO, EDAD_ALUMNO, EMAIL_ALUMNO, CURSO_ALUMNO}, null, null, null, null, null);
    }

    public Cursor obtenerTodasLasAsignaturas()
    {
        return db.query(TABLA_ASIGNATURAS, new String[]{ID_ASIGNATURA, NOMBRE_ASIGNATURA, HORAS}, null, null, null, null, null);
    }

    public Cursor obtenerNotas() throws SQLException
    {
        return db.rawQuery("SELECT " + NOMBRE_ALUMNO + ", " + NOMBRE_ASIGNATURA + ", " + NOTA_ALUMNO + " FROM " + TABLA_ALUMNOS + " INNER JOIN " + TABLA_CURSAR + " ON " + TABLA_CURSAR + "." + ID_ALUMNO_CURSANDO + " = " + TABLA_ALUMNOS + "." + ID_ALUMNO + " INNER JOIN " + TABLA_ASIGNATURAS + " ON " + TABLA_ASIGNATURAS + "." + ID_ASIGNATURA + " = " + TABLA_CURSAR + "." + ID_ASIGNATURA_CURSADA + ";",null);
    }
    // -------------------------------------------------------

    // Métodos para ACTUALIZAR un registro de la tabla
    public boolean actualizarAlumno(long IDFila, String nombre, String edad, String email, String curso)
    {
        ContentValues args = new ContentValues();
        args.put(NOMBRE_ALUMNO, nombre);
        args.put(EDAD_ALUMNO, edad);
        args.put(EMAIL_ALUMNO, email);
        args.put(CURSO_ALUMNO, curso);
        return db.update(TABLA_ALUMNOS, args, ID_ALUMNO + " = " + IDFila, null) > 0;
    }

    public boolean actualizarAsignatura(long IDFila, String nombre, String horas)
    {
        ContentValues args = new ContentValues();
        args.put(NOMBRE_ASIGNATURA, nombre);
        args.put(HORAS, horas);
        return db.update(TABLA_ASIGNATURAS, args, ID_ASIGNATURA + " = " + IDFila, null) > 0;
    }
    // -------------------------------------------------------

    public ArrayList<Estudiante> getAllEstudiantes()
    {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Cursor cursor = db.query(TABLA_ALUMNOS, new String[] {ID_ALUMNO, NOMBRE_ALUMNO, EDAD_ALUMNO, EMAIL_ALUMNO, CURSO_ALUMNO}, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            Estudiante estudiante = cursorToEstudiante(cursor);
            estudiantes.add(estudiante);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return estudiantes;
    }

    private Estudiante cursorToEstudiante(Cursor cursor)
    {
        Estudiante estudiante = new Estudiante();
        estudiante.setId_alumno(cursor.getString(0));
        estudiante.setNombre_alumno(cursor.getString(1));
        estudiante.setEdad(cursor.getString(2));
        estudiante.setEmail(cursor.getString(3));
        estudiante.setCurso(cursor.getString(4));
        Log.d("Estudiante: ", estudiante.getId_alumno() + " - " + estudiante.getNombre_alumno() + " - " + estudiante.getEdad() + " - " + estudiante.getEmail() + " - " + estudiante.getCurso());
        return estudiante;
    }
}
