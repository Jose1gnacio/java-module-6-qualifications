package com.example.demo.dto;

import com.example.demo.models.Alumno;

public class MateriaDTO {
    private Long id;
    private String nombre;
    private Alumno alumno; // o AlumnoDTO

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
