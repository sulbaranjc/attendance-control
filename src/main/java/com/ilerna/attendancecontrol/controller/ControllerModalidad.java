/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilerna.attendancecontrol.controller;

import Codigo.GestorModalidad;
import Codigo.Modalidad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michelli Fernanda
 */
@Controller
@RequestMapping("/modalidad")
public class ControllerModalidad {
    GestorModalidad ge = new GestorModalidad ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./modalidad/listarModalidad";
        try {
            model.addAttribute("modalidads", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("modalidad", new Modalidad()); 
  return "./modalidad/altaModalidad";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Modalidad modalidad, Model model) { 
        String valorfinal="./modalidad/listarModalidad";
        try {
            ge.alta(modalidad);
            try { 
                model.addAttribute("modalidads", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./modalidad/listarModalidad";
        try {
            model.addAttribute("modalidads", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./modalidad/listarModalidad";
        try {
            model.addAttribute("modalidads", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codmodalidad") int id, Model model){
        String valorfinal="./modalidad/listarmodalidad";
        try {
            ge.eliminar(id);
             model.addAttribute("modalidads", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codmodalidad") int id,Model model){
        String valorfinal="./modalidad/modificarmodalidad";
        try {
            model.addAttribute("modalidad", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Modalidad modalidad, Model model){
        String valorfinal="./modalidad/listarmodalidad";
        try {
            ge.modificar(modalidad);
            model.addAttribute("modalidads",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidad.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
}

