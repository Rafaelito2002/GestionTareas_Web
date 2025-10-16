package com.gestion.tareas.repository;

import com.gestion.tareas.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    List<Asignatura> findByDocenteId(Integer docenteId);
}