package com.ilerna.attendancecontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        // Ahora retorna la vista prueba.html
        return "./prueba";
    }
}