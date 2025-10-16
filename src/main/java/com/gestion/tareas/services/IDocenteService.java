package com.gestion.tareas.services;

import com.gestion.tareas.dto.DocenteDTO;
import java.util.List;

public interface IDocenteService {
    DocenteDTO crear(DocenteDTO dto);

    DocenteDTO actualizar(Integer id, DocenteDTO dto);

    void eliminar(Integer id);

    DocenteDTO obtenerPorId(Integer id);

    List<DocenteDTO> obtenerTodos();
}