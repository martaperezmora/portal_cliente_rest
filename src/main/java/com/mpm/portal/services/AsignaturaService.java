package com.mpm.portal.services;

import java.util.List;

import com.mpm.portal.models.Asignatura;



public interface AsignaturaService {

    public Asignatura findById(int id);

    public List<Asignatura> findAll();

    public void insert(Asignatura asignatura);

    public void update(Asignatura asignatura);

    public void delete(int id);
}
