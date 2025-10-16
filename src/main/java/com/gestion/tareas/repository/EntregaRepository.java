package com.gestion.tareas.repository;

import com.gestion.tareas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
    List<Entrega> findByTareaId(Integer tareaId);
    List<Entrega> findByEstudianteId(Integer estudianteId);

    @Query("SELECT e FROM Entrega e JOIN FETCH e.estudiante JOIN FETCH e.tarea WHERE e.tarea.id = :tareaId")
    List<Entrega> findEntregasConDetallesPorTarea(Integer tareaId);
}