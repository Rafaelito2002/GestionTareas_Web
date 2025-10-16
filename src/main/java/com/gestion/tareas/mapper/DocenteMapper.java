package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.DocenteDTO;
import com.gestion.tareas.model.Docente;
import org.springframework.stereotype.Component;

@Component
public class DocenteMapper {

    public DocenteDTO toDTO(Docente entidad) {
        if (entidad == null) return null;

        DocenteDTO dto = new DocenteDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setEmail(entidad.getEmail());
        dto.setFechaRegistro(entidad.getFechaRegistro());
        return dto;
    }

    public Docente toEntity(DocenteDTO dto) {
        if (dto == null) return null;

        Docente entidad = new Docente();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setEmail(dto.getEmail());
        entidad.setFechaRegistro(dto.getFechaRegistro());
        return entidad;
    }
}
