package com.ilerna.attendancecontrol.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/index")
    public String index() {
        // Ahora retorna la vista prueba.html
        return "index";
    }

}
