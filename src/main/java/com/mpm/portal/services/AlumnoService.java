package com.mpm.portal.services;

import java.util.List;

import com.mpm.portal.models.Alumno;



public interface AlumnoService {

    public Alumno findById(int id);

    public List<Alumno> findAll();

    public void insert(Alumno alumno);

    public void update(Alumno alumno);

    public void delete(int id);
}
