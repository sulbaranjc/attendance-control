
package com.ilerna.attendancecontrol.controller;

import Codigo.Alumno;
import Codigo.GestorAlumno;
import Codigo.GestorGrupo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/alumno")
public class controllerAlumno {
    GestorAlumno ge = new GestorAlumno ();
    GestorGrupo geGru = new GestorGrupo ();
    
   @GetMapping("/crud")
 public String crud(Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
 @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("alumno", new Alumno()); 
  return "./alumno/altaAlumno";
  }
@PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Alumno alumno, Model model) { 
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.alta(alumno);
            try { 
                model.addAttribute("alumnos", ge.listarFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
@GetMapping("/listar")
 public String listarAlumno(Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }  
 @PostMapping("/listar")
 
 public String listarAlumnos(@RequestParam ("filtro") String filtro, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            model.addAttribute("alumnos", ge.listarFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

  @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codalumno") int id, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.eliminar(id);
             model.addAttribute("alumnos", ge.listarFiltrados(""));
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
@GetMapping("/modificar")
  public String modificar(@RequestParam ("codalumno") int id,Model model){
        String valorfinal="./Alumno/modificarAlumno";
        try {
            model.addAttribute("alumno", ge.consultarUn(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  } 
@PostMapping("/modificar")
  public String modificarBBDD (@ModelAttribute Alumno alumno, Model model){
        String valorfinal="./Alumno/listarAlumno";
        try {
            ge.modificar(alumno);
            model.addAttribute("alumnos",ge.listarFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }

@GetMapping("/alumnoxgrupo")
  public String alumnoxgrupo(@RequestParam ("codalumno") int id,Model model){
        String valorfinal="./Alumno/listarAlumnoGrupo";
        try {
            model.addAttribute("alumno", ge.consultarUn(id));
            model.addAttribute("gruposxalumnos", geGru.listarPorAlumno(id));
            model.addAttribute("grupos", geGru.listarGruposFiltradosSinAlumno("",id));
            
        } catch (SQLException ex) {
            Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }  
  
@PostMapping("/alumnoxgrupo")
 public String alumnoxgrupoPost(@RequestParam ("filtro") String filtro,@RequestParam ("codalumno") int id, Model model){
        String valorfinal="./Alumno/listarAlumnoGrupo";
        try {
            model.addAttribute("gruposxalumnos", geGru.listarPorAlumno(id));
            model.addAttribute("alumno", ge.consultarUn(id));
            model.addAttribute("grupos", geGru.listarGruposFiltradosSinAlumno(filtro,id));
            model.addAttribute("filtro", filtro);

        } catch (SQLException ex) {
            Logger.getLogger(ControllerFp.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
  
@GetMapping("/altaalumnogrupo")
  public String altaalumnogrupo(@RequestParam ("codgrupo") int codgrupo,@RequestParam ("codalumno") int codalumno, Model model){ 
        String valorfinal="./Alumno/listarAlumnoGrupo";
        try {
            ge.altaAlumnoGrupo(codalumno,codgrupo);
            try { 
                model.addAttribute("gruposxalumnos", geGru.listarPorAlumno(codalumno));
                model.addAttribute("alumno", ge.consultarUn(codalumno));
            model.addAttribute("grupos", geGru.listarGruposFiltradosSinAlumno("",codalumno));
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }

@GetMapping("/eliminaralumnogrupo")
  public String eliminaralumnogrupo(@RequestParam ("codgrupo") int codgrupo,@RequestParam ("codalumno") int codalumno, Model model){ 
        String valorfinal="./Alumno/listarAlumnoGrupo";
        // System.out.println("grupo detalle a eliminar es  : "+codgrupo);
        try {
            ge.eliminarAlumnoGrupo(codgrupo);
            try { 
                model.addAttribute("gruposxalumnos", geGru.listarPorAlumno(codalumno));
                model.addAttribute("alumno", ge.consultarUn(codalumno));
            model.addAttribute("grupos", geGru.listarGruposFiltradosSinAlumno("",codalumno));
            } catch (SQLException ex) {
                Logger.getLogger(controllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }

  
}

