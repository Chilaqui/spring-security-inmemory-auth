package com.security.memory.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf((csrf) -> csrf.disable())//Desabilitado CSRF para permitir peticiones desde el cliente 
            .httpBasic((httpBasic) -> httpBasic.disable()) //Desabilitado HTTP Basic para evitar autenticación básica
            .formLogin(null) //Desabilitado Form Login para evitar autenticación basada en formularios
            .authorizeHttpRequests((auth) -> auth // Configuracion de autenticación y autorizacion
/*                 .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() //Permitir acceso a recursos estáticos comunes */
                .requestMatchers("/api").hasAuthority("Admin")//Permitir acceso a la ruta /api solo para usuarios con autoridad Admin
                .requestMatchers("/private").hasAuthority("DEVELOPER")//Permitir acceso a la ruta  solo a usuarios DEVELOPER
                .requestMatchers("/public").authenticated()//Permitir aceso a la ruta a culaquier usuario autentificado
                .requestMatchers("/actuator/**").hasAuthority("USER") //Permitir acceso a los endpoints de Actuator
                    .anyRequest().authenticated()
                    );
            
            return http.build();
            
    }
}
