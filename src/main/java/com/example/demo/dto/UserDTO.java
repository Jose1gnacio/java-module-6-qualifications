package com.example.demo.dto;

import java.util.List;

public class UserDTO {
    private String username;
    private String password;
    private List<String> roles; // Podrías tener una clase Role, pero aquí está simplificado

    // 1) Constructor por defecto (IMPORTANTE para el binding con Thymeleaf)
    public UserDTO() {
    }

    // 2) (Opcional) Constructor con argumentos
    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

