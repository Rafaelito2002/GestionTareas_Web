package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.AsignaturaDTO;
import com.gestion.tareas.model.Asignatura;
import com.gestion.tareas.model.Docente;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO toDTO(Asignatura entidad) {
        if (entidad == null) return null;

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setDescripcion(entidad.getDescripcion());

        if (entidad.getDocente() != null) {
            dto.setDocenteId(entidad.getDocente().getId());
            dto.setDocenteNombre(entidad.getDocente().getNombre());
            dto.setDocenteApellido(entidad.getDocente().getApellido());
        }

        return dto;
    }

    public Asignatura toEntity(AsignaturaDTO dto) {
        if (dto == null) return null;

        Asignatura entidad = new Asignatura();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());

        if (dto.getDocenteId() != null) {
            Docente docente = new Docente();
            docente.setId(dto.getDocenteId());
            entidad.setDocente(docente);
        }

        return entidad;
    }
}