package com.example.vertice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button alumnnos, asignaturas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    public void AbrirAlumnos(View view)
    {
        Intent intent = new Intent(this, Alumnos.class);
        startActivity(intent);
    }
    public void AbrirAsignaturas(View view)
    {
        Intent intent = new Intent(this, Asignaturas.class);
        startActivity(intent);
    }
}