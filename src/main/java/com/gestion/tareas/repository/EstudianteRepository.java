package com.gestion.tareas.repository;

import com.gestion.tareas.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Interface Segregation Principle (ISP)
// Solo expone métodos necesarios

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    Optional<Estudiante> findByEmail(String email);
}