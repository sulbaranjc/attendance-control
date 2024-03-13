package com.ilerna.attendancecontrol.controller;
import Codigo.Profesor;
import Codigo.SingletonProfesor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/index")
    public String Index(Model model){
        if (SingletonProfesor.isSesion()) {
            model.addAttribute("profesor",SingletonProfesor.getProfesor());
            model.addAttribute("accion","Identificate");
        }else{
            Profesor p= new Profesor();
            p.setNombre("");
            p.setApellido("");
            model.addAttribute("profesor",p);
            model.addAttribute("accion","Identificate");
        }
        return "./index";
    }

    @GetMapping("/logout")
    public ModelAndView logout(Model model){
        SingletonProfesor.logoutProfesor();
//        model.addAttribute("profesor",SingletonProfesor.getProfesor().getNombre());
//        model.addAttribute("accion","Cerrar Sesión");
        model.addAttribute("profesor",new Profesor());
        return new ModelAndView("/index", model.asMap());
    }




}

