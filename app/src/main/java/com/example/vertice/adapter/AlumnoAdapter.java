package com.example.vertice.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vertice.R;
import com.example.vertice.alumnos.Estudiante;

import java.util.ArrayList;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.MyViewHolder>
{
    Context context;
    ArrayList<Estudiante> estudiantes;

    public AlumnoAdapter(Context ct, ArrayList<Estudiante> estudiantes)
    {
        context = ct;
        this.estudiantes = estudiantes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_alumnos, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        // Lista clicable aqui
        holder.tvIdAlumno.setText(estudiantes.get(position).getId_alumno());
        Log.d("ID ALUMNO: ", String.valueOf(estudiantes.get(position)));

        holder.tvNombreAlumno.setText(estudiantes.get(position).getNombre_alumno());
        Log.d("NOMBRE: ", estudiantes.get(position).getNombre_alumno());

        holder.tvEdadAlumno.setText(estudiantes.get(position).getEdad());
        Log.d("EDAD: ", estudiantes.get(position).getEdad());

        holder.tvEmailAlumno.setText(estudiantes.get(position).getEmail());
        Log.d("EMAIL: ", estudiantes.get(position).getEmail());

        holder.tvCursoAlumno.setText(estudiantes.get(position).getCurso());
        Log.d("CURSO: ", estudiantes.get(position).getCurso());
    }

    @Override
    public int getItemCount()
    {
        return estudiantes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvIdAlumno, tvNombreAlumno, tvEdadAlumno, tvEmailAlumno, tvCursoAlumno;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tvIdAlumno = itemView.findViewById(R.id.tvRowAlumnoId);
            tvNombreAlumno = itemView.findViewById(R.id.tvRowNombreAlumno);
            tvEdadAlumno = itemView.findViewById(R.id.tvRowEdadAlumno);
            tvEmailAlumno = itemView.findViewById(R.id.tvRowEmailAlumno);
            tvCursoAlumno = itemView.findViewById(R.id.tvRowCursoAlumno);
        }
    }
}
