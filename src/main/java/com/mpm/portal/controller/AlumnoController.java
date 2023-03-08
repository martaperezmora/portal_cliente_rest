package com.mpm.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mpm.portal.models.Alumno;
import com.mpm.portal.services.AlumnoService;

@Controller
@RequestMapping("/alumnos")

public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/lista")
    public ModelAndView listPage(Model model) {

        List<Alumno> alumnos = alumnoService.findAll();

        ModelAndView modelAndView = new ModelAndView("alumnos/list");
        modelAndView.addObject("alumnos", alumnos);

        return modelAndView;
    }

    @RequestMapping(value = { "/nuevo" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("alumnos/nuevo");

        return modelAndView;
    }

    @PostMapping(path = { "/guardar" })
    public ModelAndView guardar(Alumno alumno) {
        ModelAndView modelAndView = new ModelAndView();
        alumnoService.insert(alumno);
        modelAndView.setViewName("redirect:editar/" + alumno.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/editar/{codigo}" })
    public ModelAndView editar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        Alumno alumno = alumnoService.findById(codigo);
        modelAndView.addObject("alumno", alumno);
        modelAndView.setViewName("alumnos/editar");

        return modelAndView;
    }

    @PostMapping(path = { "/modificar" })
    public ModelAndView modificar(Alumno alumno) {

        ModelAndView modelAndView = new ModelAndView();
        alumnoService.update(alumno);
        modelAndView.setViewName("redirect:editar/" + alumno.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/borrar/{codigo}" })
    public ModelAndView borrar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();

        alumnoService.delete(codigo);
        modelAndView.setViewName("redirect:../lista");

        return modelAndView;
    }

}
