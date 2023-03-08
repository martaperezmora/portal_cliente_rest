package com.mpm.portal.services.impl;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mpm.portal.models.Asignatura;
import com.mpm.portal.services.AsignaturaService;


@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Value("${url.matricula.rest.service}")
    String urlAsignaturas;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Asignatura findById(int codigo) {
        return restTemplate.getForObject(urlAsignaturas + "asignaturas/{codigo}", Asignatura.class, codigo);
    }

    @Override
    public List<Asignatura> findAll() {
        Asignatura[] ca = restTemplate.getForObject(urlAsignaturas + "asignaturas", Asignatura[].class); // array json de asignaturas
        List<Asignatura> asignaturas = Arrays.asList(ca);

        return asignaturas;
    }

    @Override
    public void insert(Asignatura asignatura) {
        Asignatura asignaturaResponse = restTemplate.postForObject(urlAsignaturas + "asignaturas", asignatura, Asignatura.class);
        asignatura.setCodigo(asignaturaResponse.getCodigo());
    }

    @Override
    public void update(Asignatura asignatura) {
        restTemplate.put(urlAsignaturas + "asignaturas/{codigo}", asignatura, asignatura.getCodigo());
    }

    @Override
    public void delete(int codigo) {
        restTemplate.delete(urlAsignaturas + "asignaturas/{codigo}", codigo);
    }
    
}
