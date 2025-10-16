package com.gestion.tareas.services;


import com.gestion.tareas.dto.EntregaDTO;
import java.util.List;

public interface IEntregaService {
    EntregaDTO crear(EntregaDTO dto);

    EntregaDTO actualizar(Integer id, EntregaDTO dto);

    void eliminar(Integer id);

    EntregaDTO obtenerPorId(Integer id);

    List<EntregaDTO> obtenerTodos();

    List<EntregaDTO> obtenerPorTarea(Integer tareaId);

    List<EntregaDTO> obtenerPorEstudiante(Integer estudianteId);
}