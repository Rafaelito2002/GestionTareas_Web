package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.EntregaDTO;
import com.gestion.tareas.model.Entrega;
import com.gestion.tareas.model.Estudiante;
import com.gestion.tareas.model.Tarea;
import org.springframework.stereotype.Component;

@Component
public class EntregaMapper {

    public EntregaDTO toDTO(Entrega entidad) {
        if (entidad == null) return null;

        EntregaDTO dto = new EntregaDTO();
        dto.setId(entidad.getId());
        dto.setFechaEntrega(entidad.getFechaEntrega());
        dto.setArchivo(entidad.getArchivo());
        dto.setCalificacion(entidad.getCalificacion());

        if (entidad.getEstudiante() != null) {
            dto.setEstudianteId(entidad.getEstudiante().getId());
            dto.setEstudianteNombre(entidad.getEstudiante().getNombre());
            dto.setEstudianteApellido(entidad.getEstudiante().getApellido());
        }

        if (entidad.getTarea() != null) {
            dto.setTareaId(entidad.getTarea().getId());
            dto.setTareaNombre(entidad.getTarea().getNombre());

            if (entidad.getTarea().getAsignatura() != null) {
                dto.setAsignaturaNombre(entidad.getTarea().getAsignatura().getNombre());
            }
        }

        return dto;
    }

    public Entrega toEntity(EntregaDTO dto) {
        if (dto == null) return null;

        Entrega entidad = new Entrega();
        entidad.setId(dto.getId());
        entidad.setFechaEntrega(dto.getFechaEntrega());
        entidad.setArchivo(dto.getArchivo());
        entidad.setCalificacion(dto.getCalificacion());

        if (dto.getEstudianteId() != null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(dto.getEstudianteId());
            entidad.setEstudiante(estudiante);
        }

        if (dto.getTareaId() != null) {
            Tarea tarea = new Tarea();
            tarea.setId(dto.getTareaId());
            entidad.setTarea(tarea);
        }

        return entidad;
    }
}