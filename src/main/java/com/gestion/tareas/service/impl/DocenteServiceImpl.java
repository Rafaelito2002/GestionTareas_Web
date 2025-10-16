package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.DocenteDTO;
import com.gestion.tareas.model.Docente;
import com.gestion.tareas.repository.DocenteRepository;
import com.gestion.tareas.services.IDocenteService;
import com.gestion.tareas.mapper.DocenteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DocenteServiceImpl implements IDocenteService {

    private final DocenteRepository repository;
    private final DocenteMapper mapper;

    @Override
    public DocenteDTO crear(DocenteDTO dto) {
        dto.setFechaRegistro(LocalDate.now());
        Docente entidad = mapper.toEntity(dto);
        Docente guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public DocenteDTO actualizar(Integer id, DocenteDTO dto) {
        Docente entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setEmail(dto.getEmail());

        Docente actualizado = repository.save(entidad);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Docente no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public DocenteDTO obtenerPorId(Integer id) {
        Docente entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        return mapper.toDTO(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocenteDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}