package com.security.memory.controller;

import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAutority('USER')")// Asegura que solo los usuarios con autoridad 'USER' puedan acceder a este controlador
@RequestMapping("/api") // Define la ruta base para este controlador
public class LogginController {

    @GetMapping("/loggin")
    @PreAuthorize("hasAuthority('ADMIN')") // Asegura que solo los usuarios con autoridad 'ADMIN' puedan acceder a este endpoint
    public String adminMenssage(){
        return "Welcome to the admin page!"; // Mensaje de bienvenida para la página de administrador
    }
    



}
