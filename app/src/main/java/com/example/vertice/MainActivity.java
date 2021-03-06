package com.example.vertice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vertice.preferencias.Preferencies;

public class MainActivity extends AppCompatActivity
{
    EditText usuario;
    EditText password;

    Button registerButton;
    Button loginButton;

    Preferencies pref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = new Preferencies(this);

        usuario = findViewById(R.id.editTextUsuario);
        password = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.registrarButton);
        loginButton = findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                guardarUsuario();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Los EditText NO están vacios
                if(usuario.getText().toString().equals(pref.getUser()) && password.getText().toString().equals(pref.getPassword()))
                {
                    Toast.makeText(getApplicationContext(), "Intent a la actividad", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void guardarUsuario()
    {
        // Los EditText NO están vacios
        if(!usuario.getText().toString().equals("") && !password.getText().toString().equals(""))
        {
            pref.setUser(usuario.getText().toString());
            pref.setPassword(password.getText().toString());
            Toast.makeText(getApplicationContext(), "Se ha guardado tu usuario", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Introduce un valor válido", Toast.LENGTH_LONG).show();
        }
    }

    public void AbrirMenu(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
    private void logIn()
    {

    }
}