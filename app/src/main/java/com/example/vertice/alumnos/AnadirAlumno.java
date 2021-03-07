package com.example.vertice.alumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vertice.BBDD.StudyWorldBBDD;
import com.example.vertice.R;

import java.io.ByteArrayOutputStream;


public class AnadirAlumno extends AppCompatActivity
{
    private int GALLERY_REQUEST_CODE = 1;
    private int APP_PERMISSION_READ_STORAGE = 1;

    // Creamos los botones y los campos de texto que usaremos para añadir alumnos
    private StudyWorldBBDD db;
    private EditText editName, editEdad, editEmail, editCurso;
    private Button addButton;

    private Uri imageUri;

    private byte[] bitmapmap;
    private static final int PICK_IMAGE = 100;
    private ImageView fotoAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_alumno);

        fotoAlumno = findViewById(R.id.imagenAlumno);

        editName = findViewById(R.id.editCalificarIDAsignatura);
        editEdad = findViewById(R.id.editNota);
        editEmail = findViewById(R.id.editRefreshEmailAlumno);
        editCurso= findViewById(R.id.editRefreshCursoAlumno);
        editName = findViewById(R.id.editCalificarIDAsignatura);

        addButton = findViewById(R.id.addNuevaAsignatura);
        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Aqui hacemos un control de errores para evitar que el usuario introduzca datos vacios en la bdd
                // Decdimos que un alumno puede estar en la bdd sin tener el curso adjudicado.
                if (editName.getText().toString().equals("") || editEdad.getText().toString().equals("") || editEmail.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No puedes meter valores vacios en la base de datos", Toast.LENGTH_SHORT).show();
                    finish();
                }
                // Si el usario mete datos con contendio seguimos con el programa y metemos los datos del alumno en la base de datos.
                else {
                    db = new StudyWorldBBDD(getApplicationContext());
                    db.obre();
                    if(db.añadirAlumno(editName.getText().toString(), editEdad.getText().toString(), editEmail.getText().toString(), editCurso.getText().toString()) != -1)
                    {
                        Toast.makeText(getApplicationContext(), "Añadido correctamente", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "FALLO AL AÑADIR", Toast.LENGTH_SHORT).show();
                    }
                    db.tanca();
                    finish();
                }
            }
        });

        fotoAlumno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

//                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(getParent(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, APP_PERMISSION_READ_STORAGE);
//                }
                openGallery();
            }
        });
    }

    private void openGallery()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE)
        {
            imageUri = data.getData();
            fotoAlumno.setImageURI(imageUri);
        }
    }
}