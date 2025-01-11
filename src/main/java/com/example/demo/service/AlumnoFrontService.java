package com.example.demo.service;

import com.example.demo.dto.AlumnoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class AlumnoFrontService {

    private final RestTemplate restTemplate = new RestTemplate();
    
    public List<AlumnoDTO> findAll() {
        // Aquí llamamos al endpoint del backend /api/alumnos
        String url = "http://localhost:8080/api/alumnos";
        AlumnoDTO[] respuesta = restTemplate.getForObject(url, AlumnoDTO[].class);
        return Arrays.asList(respuesta);
    }
}
