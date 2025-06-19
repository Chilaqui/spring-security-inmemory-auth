package com.security.memory.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;




@Configuration // Marca esta clase como una clase de configuración de Spring, permitiendo la definición de beans y configuraciones
@EnableWebSecurity // Habilita la configuración de seguridad web, permitiendo la personalización de la seguridad HTTP
@EnableMethodSecurity // Habilita la seguridad a nivel de método, permitiendo el uso de anotaciones como @PreAuthorize
public class SecurityConfig {
    
    /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf((csrf) -> csrf.disable())//Desabilitado CSRF para permitir peticiones desde el cliente 
            .httpBasic((httpBasic) -> httpBasic.disable()) //Desabilitado HTTP Basic para evitar autenticación básica
            .formLogin(withDefaults()) //Habilitado el formulario de inicio de sesión por defecto
            .authorizeHttpRequests((auth) -> auth // Configuracion de autenticación y autorizacion
                .requestMatchers("login","/css/", "/js/", "/images/").permitAll() //Permitir acceso a la ruta de inicio de sesión sin autenticación
                .requestMatchers("/api").hasAuthority("ADMIN")//Permitir acceso a la ruta /api solo para usuarios con autoridad Admin
                .requestMatchers("/private").hasAuthority("DEVELOPER")//Permitir acceso a la ruta  solo a usuarios DEVELOPER
                .requestMatchers("/public").authenticated()//Permitir aceso a la ruta a culaquier usuario autentificado
                .requestMatchers("/actuator/**").hasAuthority("USER") //Permitir acceso a los endpoints de Actuator
                    .anyRequest().authenticated()
                    );
            
            return http.build();
            
    } */

    @Bean
    public UserDetailsService users(){
        UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
            .username("user")
            .password("2080")
            .authorities("USER")
            .build();

        UserDetails admin = users
            .username("admin")
            .password("4080")
            .authorities("ADMIN")
            .build();

        UserDetails developer = users
            .username("developer")
            .password("6080")
            .authorities("DEVELOPER")
            .build();
        return new InMemoryUserDetailsManager(user, admin, developer);
    }
}
