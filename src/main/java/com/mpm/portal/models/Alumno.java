package com.mpm.portal.models;

import java.util.Date;
import java.util.List;



public class Alumno {

    private int codigo;
    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private String telefono;


    private List<Asignatura> asignaturas;

    public Alumno(int codigo, String nombre, String apellidos, String email, Date fechaNacimiento, String telefono,
            List<Asignatura> asignaturas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.asignaturas = asignaturas;
    }

    public Alumno(String nombre, String apellidos, String email, Date fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public Alumno() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    
}
