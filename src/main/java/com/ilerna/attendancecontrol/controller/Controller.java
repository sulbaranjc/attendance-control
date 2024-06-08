package com.ilerna.attendancecontrol.controller;
import Codigo.*;
import Codigo.GestorAsignaturaGrupo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/index")
    public String index(@RequestParam(value = "periodoId", required = false) Integer periodoId, Model model) {
        if (periodoId == null) {
            periodoId = 1;
        }
        model.addAttribute("periodoId",periodoId);
        if (SingletonProfesor.isSesion()) {
            model.addAttribute("profesor",SingletonProfesor.getProfesor());
            // Cargar periodos
            GestorPeriodo gestorPeriodo = new GestorPeriodo();
            try {
                model.addAttribute("periodos", gestorPeriodo.listar());
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                return "error";
            }
            // Cargar asignaturas
            GestorAsignaturaGrupo gestorAsignaturaGrupo = new GestorAsignaturaGrupo();
            try {
                model.addAttribute("asignaturasGrupo", gestorAsignaturaGrupo.listar(SingletonProfesor.getProfesor().getId(),periodoId));
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                return "error";
            }
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

    // Devuelve las asignaturas de un profesor en un periodo para cargas dinamicas con AJAX
    @GetMapping("/asignaturasPorPeriodo")
    @ResponseBody // Asegura que la respuesta sea JSON
    public ResponseEntity<List<AsignaturaGrupo>> getAsignaturasPorPeriodo(@RequestParam("periodoId") int periodoId) {
        if (!SingletonProfesor.isSesion()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            GestorAsignaturaGrupo gestorAsignaturaGrupo = new GestorAsignaturaGrupo();
            List<AsignaturaGrupo> asignaturas = gestorAsignaturaGrupo.listar(SingletonProfesor.getProfesor().getId(), periodoId);
            return ResponseEntity.ok(asignaturas);
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

