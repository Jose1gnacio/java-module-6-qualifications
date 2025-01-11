package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    // Métodos personalizados si es necesario.
}
