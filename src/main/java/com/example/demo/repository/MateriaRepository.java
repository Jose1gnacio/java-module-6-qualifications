package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
    // Métodos personalizados si es necesario.
}
