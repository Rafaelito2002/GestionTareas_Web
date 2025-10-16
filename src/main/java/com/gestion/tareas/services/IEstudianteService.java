package com.gestion.tareas.services;

import com.gestion.tareas.dto.EstudianteDTO;
import java.util.List;

// Dependency Inversion Principle (DIP)
// Los módulos de alto nivel dependen de abstracciones, no de implementaciones

public interface IEstudianteService {

    EstudianteDTO crear(EstudianteDTO dto);

    EstudianteDTO actualizar(Integer id, EstudianteDTO dto);

    void eliminar(Integer id);

    EstudianteDTO obtenerPorId(Integer id);

    List<EstudianteDTO> obtenerTodos();

}