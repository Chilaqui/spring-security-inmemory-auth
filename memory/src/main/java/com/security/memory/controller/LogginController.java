package com.security.memory.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth") // Define la ruta base para este controlador
public class LogginController {

 
    @GetMapping("/private")
    @PreAuthorize("hasAnyAuthority('DEVELOPER','ADMIN')") // Asegura que solo los usuarios con autoridad 'DEVELOPER' puedan acceder a este endpoint
    public String developerMenssage(){
        return "Welcome to the DEVELOPER page!"; // Mensaje de bienvenida para la página de administrador
    }

    @GetMapping("/public")
    @PreAuthorize("hasAuthority('USER')") // Asegura que solo los usuarios
    public String publicMenssage(){
        return "Welcome to the PUBLIC page!"; // Mensaje de bienvenida para la página pública
    }

    @GetMapping("/api")
    @PreAuthorize("hasAuthority('ADMIN')") // Asegura que solo los usuarios
    public String adminMenssage(){
        return "Welcome to the ADMIN page!"; // Mensaje de bienvenida para la página de administrador
    }

    @GetMapping("/actuator")
    @PreAuthorize("hasAuthority('USER')") // Asegura que solo los usuarios
    public String actuatorMenssage(){
        return "Welcome to the ACTUATOR page!"; // Mensaje de bienvenida para la
    }
    
    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()") // Asegura que solo los usuarios autenticados puedan acceder a este endpoint
    public String home(){
        return "Welcome to the ALL page!"; // Mensaje de bienvenida para la página de todos los usuarios
    }

    

   

}
