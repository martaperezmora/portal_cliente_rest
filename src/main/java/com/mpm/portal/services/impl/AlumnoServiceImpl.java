package com.mpm.portal.services.impl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mpm.portal.models.Alumno;
import com.mpm.portal.services.AlumnoService;


@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Value("${url.matricula.rest.service}")
    String urlAlumnos;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Alumno findById(int codigo) {
        return restTemplate.getForObject(urlAlumnos + "alumnos/{codigo}", Alumno.class, codigo);
    }

    @Override
    public List<Alumno> findAll() {
        Alumno[] ca = restTemplate.getForObject(urlAlumnos + "alumnos", Alumno[].class); // array json de alumnos
        List<Alumno> alumnos = Arrays.asList(ca);

        return alumnos;
    }

    @Override
    public void insert(Alumno alumno) {
        Alumno alumnoResponse = restTemplate.postForObject(urlAlumnos + "alumnos", alumno, Alumno.class);
        alumno.setCodigo(alumnoResponse.getCodigo());
    }

    @Override
    public void update(Alumno alumno) {
        restTemplate.put(urlAlumnos + "alumnos/{codigo}", alumno, alumno.getCodigo());
    }

    @Override
    public void delete(int codigo) {
        restTemplate.delete(urlAlumnos + "alumnos/{codigo}", codigo);
    }
    
}
