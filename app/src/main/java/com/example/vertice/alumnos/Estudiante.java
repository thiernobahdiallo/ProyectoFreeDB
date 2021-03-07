package com.example.vertice.alumnos;

public class Estudiante
{
    String id_alumno, nombre_alumno, edad, email, curso;

    public String getId_alumno()
    {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno)
    {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno()
    {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno)
    {
        this.nombre_alumno = nombre_alumno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
