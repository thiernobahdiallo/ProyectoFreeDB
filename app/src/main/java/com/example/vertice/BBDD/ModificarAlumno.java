package com.example.vertice.BBDD;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vertice.R;

public class ModificarAlumno extends AppCompatActivity {
    VerticeBBDD db;
    Button refresh;
    private EditText editId, editName, editEdad,editEmail,editCurso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_alumno);

        refresh = findViewById(R.id.refreshButtoncito);
        editId = findViewById(R.id.editTextID);
        editName = findViewById(R.id.editName);
        editEdad = findViewById(R.id.editEdad);
        editEmail = findViewById(R.id.editEmail);
        editCurso= findViewById(R.id.editCurso);
        refresh.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                long id;
                db = new VerticeBBDD(getApplicationContext());
                db.obre();
                id = Long.parseLong(editId.getText().toString());
                boolean result = db.actualizarAlumno(id,editName.getText().toString(), editEdad.getText().toString(), editEmail.getText().toString(), editCurso.getText().toString());
                if(result)
                {
                    Toast.makeText(getApplicationContext(), "Element modificat", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No se ha podido modificar", Toast.LENGTH_SHORT).show();
                    db.tanca();
                    finish();
                }
            }
        });
    }
}