package com.example.vertice.BBDD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vertice.R;

public class DeleteAlumno extends AppCompatActivity {

    VerticeBBDD db;
    Button deleteButton;
    EditText editTextId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_alumno);

        deleteButton = findViewById(R.id.deleteButtoncito);
        editTextId = findViewById(R.id.editTextIDdelete);

        deleteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                db = new VerticeBBDD(getApplicationContext());
                db.obre();
                long id = Long.parseLong(editTextId.getText().toString());
                boolean result = db.borrarAlumno(id);
                if(result)
                {
                    Toast.makeText(getApplicationContext(), "Element esborrat", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No se ha borrado el elemento", Toast.LENGTH_SHORT).show();
                }
                db.tanca();
                finish();
            }
        });
    }
}