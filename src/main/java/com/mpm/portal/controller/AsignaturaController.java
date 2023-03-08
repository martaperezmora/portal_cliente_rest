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

import com.mpm.portal.models.Asignatura;
import com.mpm.portal.services.AsignaturaService;

@Controller
public class AsignaturaController {
    
    @Autowired
    AsignaturaService asignaturaService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value = "/lista")
    public ModelAndView listPage(Model model) {

        List<Asignatura> asignaturas = asignaturaService.findAll();

        ModelAndView modelAndView = new ModelAndView("asignaturas/list");
        modelAndView.addObject("asignaturas", asignaturas);

        return modelAndView;
    }

    @RequestMapping(value = { "/nuevo" })
    public ModelAndView nuevo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("asignaturas/nuevo");

        return modelAndView;
    }

    @PostMapping(path = { "/guardar" })
    public ModelAndView guardar(Asignatura asignatura) {
        ModelAndView modelAndView = new ModelAndView();
        asignaturaService.insert(asignatura);
        modelAndView.setViewName("redirect:editar/" + asignatura.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/editar/{codigo}" })
    public ModelAndView editar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();
        Asignatura asignatura = asignaturaService.findById(codigo);
        modelAndView.addObject("asignatura", asignatura);
        modelAndView.setViewName("asignaturas/editar");

        return modelAndView;
    }

    @PostMapping(path = { "/modificar" })
    public ModelAndView modificar(Asignatura asignatura) {

        ModelAndView modelAndView = new ModelAndView();
        asignaturaService.update(asignatura);
        modelAndView.setViewName("redirect:editar/" + asignatura.getCodigo());

        return modelAndView;
    }

    @GetMapping(path = { "/borrar/{codigo}" })
    public ModelAndView borrar(@PathVariable(name = "codigo", required = true) int codigo) {
        ModelAndView modelAndView = new ModelAndView();

        asignaturaService.delete(codigo);
        modelAndView.setViewName("redirect:../lista");

        return modelAndView;
    }

}
