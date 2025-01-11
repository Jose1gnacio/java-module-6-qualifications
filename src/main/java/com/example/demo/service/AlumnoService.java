package com.example.demo.service;

import com.example.demo.models.Alumno;
import com.example.demo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class AlumnoService {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno save(Alumno alumno) {
        logger.info("Guardando Alumno: {}", alumno.getNombre());
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll() {
        logger.info("Buscando todos los alumnos");
        return alumnoRepository.findAll();
    }
}
