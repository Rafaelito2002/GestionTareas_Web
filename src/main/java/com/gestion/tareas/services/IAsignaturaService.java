package com.gestion.tareas.services;

import com.gestion.tareas.dto.AsignaturaDTO;
import java.util.List;

public interface IAsignaturaService {
    AsignaturaDTO crear(AsignaturaDTO dto);

    AsignaturaDTO actualizar(Integer id, AsignaturaDTO dto);

    void eliminar(Integer id);

    AsignaturaDTO obtenerPorId(Integer id);

    List<AsignaturaDTO> obtenerTodos();

    List<AsignaturaDTO> obtenerPorDocente(Integer docenteId);
}