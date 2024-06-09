package com.ilerna.attendancecontrol.controller;

import Codigo.AsistenciaDetalle;
import Codigo.GestorAsignatura;
import Codigo.GestorAsignaturaGrupo;
import Codigo.GestorAsistenciaDetalle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador para gestionar los detalles de asistencia
 */
@Controller
@RequestMapping("/asistencia")
public class ControllerAsistenciaDetalle {
    GestorAsistenciaDetalle gestorAsistencia = new GestorAsistenciaDetalle();

    @GetMapping("/listar")
    public String listarAsistencias(@RequestParam(value = "asigGruId", defaultValue = "0") int asigGruId,
                                    @RequestParam(value = "filtro", defaultValue = "") String filtro,
                                    Model model) {
        String vista = "./asistencia/listarAsistencia";
        System.out.println("Filtro: " + filtro);
        System.out.println("AsigGruId: " + asigGruId);
        try {
            if (filtro.isEmpty()) {
                model.addAttribute("asistencias", gestorAsistencia.listar(asigGruId));
            } else {
                model.addAttribute("asistencias", gestorAsistencia.listarFiltrados(asigGruId,filtro));
            }
            GestorAsignaturaGrupo geGru = new GestorAsignaturaGrupo ();
            model.addAttribute("asigGruNombre", geGru.consultarUn(asigGruId).getNombreIdAsignatura());
            //model.addAttribute("asigGruNombre", ge.consultarUn(asigGruId).getNombreAsignatura());
            model.addAttribute("asigGruId", asigGruId); // Para usarlo en la vista, si es necesario
            model.addAttribute("filtro", filtro); // Para usarlo en la vista, si es necesario
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAsistenciaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            vista = "error";
        }
        return vista;
    }
    @PostMapping("/listar")
    public String listarAlumnos(@RequestParam("filtro") String filtro, @RequestParam("asigGruId") int asigGruId, Model model) {
        String valorfinal = "./asistencia/listarAsistencia";
        System.out.println("Filtro: " + filtro);
        System.out.println("AsigGruId: " + asigGruId);
        try {
            if (filtro.isEmpty()) {
                model.addAttribute("asistencias", gestorAsistencia.listar(asigGruId));
            } else {
                model.addAttribute("asistencias", gestorAsistencia.listarFiltrados(asigGruId,filtro));
            }
            GestorAsignaturaGrupo geGru = new GestorAsignaturaGrupo ();
            model.addAttribute("asigGruNombre", geGru.consultarUn(asigGruId).getNombreIdAsignatura());
            model.addAttribute("filtro", filtro);
            model.addAttribute("asigGruId", asigGruId);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAsistenciaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal = "error";
        }
        return valorfinal;
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(@RequestParam("idAsistencia") int id, Model model) {
        String vista = "./asistencia/detalleAsistencia";
        try {
            AsistenciaDetalle asistencia = gestorAsistencia.consultarUn(id);
            model.addAttribute("asistencia", asistencia);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAsistenciaDetalle.class.getName()).log(Level.SEVERE, null, ex);
            vista = "error";
        }
        return vista;
    }
}
