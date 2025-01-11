package com.example.demo.controller;

import com.example.demo.dto.AlumnoDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.AlumnoFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AlumnoFrontService alumnoFrontService;

    // Muestra la vista de login (GET). Spring Security usará /login en POST.
    @GetMapping("/login")
    public String login(Model model) {
        // Opcional: Agregar un userDTO, si tu plantilla lo usa para mostrar datos
        model.addAttribute("userDTO", new UserDTO());
        return "login"; // templates/login.html
    }

    // Eliminamos / renombramos el doLogin (@PostMapping("/login")) 
    // porque Spring Security ya intercepta el POST /login.

    // Muestra la vista home con la lista de alumnos
    @GetMapping("/home")
    public String home(Model model) {
        List<AlumnoDTO> alumnos = alumnoFrontService.findAll();
        model.addAttribute("alumnos", alumnos);
        return "home"; // templates/home.html
    }
}

