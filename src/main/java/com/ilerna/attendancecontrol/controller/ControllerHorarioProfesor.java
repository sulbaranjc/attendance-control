package com.ilerna.attendancecontrol.controller;

import Codigo.GestorHorarioProfesor;
import Codigo.HorarioProfesor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/horario")
public class ControllerHorarioProfesor {
    GestorHorarioProfesor gestorHorarioProfesor = new GestorHorarioProfesor();

    @GetMapping("/consultar")
    public String consultarHorario(@RequestParam("idProfesor") int idProfesor,
                                   @RequestParam("idPeriodo") int idPeriodo,
                                   Model model) {
        String valorfinal = "./horarios/mostrarHorarioProfesor";
        try {
            List<HorarioProfesor> horarios = gestorHorarioProfesor.obtenerHorario(idProfesor, idPeriodo);
            model.addAttribute("horarios", horarios);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorarioProfesor.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal = "error";
        }
        return valorfinal;
    }
}
