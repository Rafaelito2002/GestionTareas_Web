package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.EstudianteDTO;
import com.gestion.tareas.model.Estudiante;
import org.springframework.stereotype.Component;

// Single Responsibility Principle (SRP)
// Solo se encarga de mapear entre Entity y DTO
@Component
public class EstudianteMapper {

    public EstudianteDTO toDTO(Estudiante entidad) {
        if (entidad == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setEmail(entidad.getEmail());
        dto.setFechaRegistro(entidad.getFechaRegistro());
        return dto;
    }

    public Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;

        Estudiante entidad = new Estudiante();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setEmail(dto.getEmail());
        entidad.setFechaRegistro(dto.getFechaRegistro());
        return entidad;
    }
}