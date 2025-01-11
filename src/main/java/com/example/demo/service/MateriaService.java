package com.example.demo.service;

import com.example.demo.models.Materia;
import com.example.demo.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MateriaService {

    private static final Logger logger = LoggerFactory.getLogger(MateriaService.class);

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia save(Materia materia) {
        logger.info("Guardando Materia: {}", materia.getNombre());
        return materiaRepository.save(materia);
    }
}
