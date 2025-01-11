package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy; // Si quieres usarlo
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * 1) Filtro principal de seguridad.
     * Configuramos:
     *  - Rutas públicas
     *  - formLogin
     *  - (opcional) Sesión
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // (A) Deshabilitamos CSRF por simplicidad
        http.csrf().disable();

        // (B) Configuramos autorización de peticiones
        http.authorizeHttpRequests(auth -> auth
            // Rutas públicas (sin login)
            .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
            // Cualquier otra ruta requiere login
            .anyRequest().authenticated()
        );

        // (C) Configuramos formLogin, indicando la página de login
        http.formLogin(form -> form
            .loginPage("/login")         // La URL donde está TU página de login
            .defaultSuccessUrl("/home")  // A dónde redirigir tras login exitoso
            .permitAll()                 // Permitir acceso a /login sin estar autenticado
        );

        /*
         * (D) Opcional: Si pones STATELESS, NO tendrás sesión de usuario.
         *     Para formulario normal, lo usual es usar sesiones (IF_REQUIRED).
         */
        // http.sessionManagement(session ->
        //     session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        // );

        // (Opcional) Descomenta si quieres soportar login HTTP Basic
        // http.httpBasic(Customizer.withDefaults());

        // Construimos el filtro final
        return http.build();
    }

    /**
     * 2) Ignoramos la seguridad para /api/** si quieres exponer tus endpoints
     *    sin forzar login.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers("/api/**");
    }

    /**
     * 3) Definimos un PasswordEncoder (recomendado en producción).
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 4) Creamos un AuthenticationManager con un usuario en memoria
     *    para pruebas: admin / admin
     */
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);

        authBuilder.inMemoryAuthentication()
                   .withUser("admin")
                   .password(passwordEncoder().encode("admin"))
                   .roles("ADMIN");

        return authBuilder.build();
    }
}

