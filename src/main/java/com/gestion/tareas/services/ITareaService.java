package com.gestion.tareas.services;

import com.gestion.tareas.dto.TareaDTO;
import java.util.List;

public interface ITareaService {
    TareaDTO crear(TareaDTO dto);

    TareaDTO actualizar(Integer id, TareaDTO dto);

    void eliminar(Integer id);

    TareaDTO obtenerPorId(Integer id);

    List<TareaDTO> obtenerTodos();

    List<TareaDTO> obtenerPorAsignatura(Integer asignaturaId);
}