package com.mpm.portal.models;

import java.util.List;


public class Asignatura {


    private int id;


    private String codigo;
    private String descripcion;

    private List<Alumno> alumnos;

    public Asignatura(int id, String codigo, String descripcion, List<Alumno> alumnos) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.alumnos = alumnos;
    }

    public Asignatura(String codigo, String descripcion, List<Alumno> alumnos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.alumnos = alumnos;
    }

    public Asignatura() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
