package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.TareaDTO;
import com.gestion.tareas.model.Tarea;
import com.gestion.tareas.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class TareaMapper {

    public TareaDTO toDTO(Tarea entidad) {
        if (entidad == null) return null;

        TareaDTO dto = new TareaDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setFechaEntrega(entidad.getFechaEntrega());

        if (entidad.getAsignatura() != null) {
            dto.setAsignaturaId(entidad.getAsignatura().getId());
            dto.setAsignaturaNombre(entidad.getAsignatura().getNombre());
        }

        return dto;
    }

    public Tarea toEntity(TareaDTO dto) {
        if (dto == null) return null;

        Tarea entidad = new Tarea();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setFechaEntrega(dto.getFechaEntrega());

        if (dto.getAsignaturaId() != null) {
            Asignatura asignatura = new Asignatura();
            asignatura.setId(dto.getAsignaturaId());
            entidad.setAsignatura(asignatura);
        }

        return entidad;
    }
}