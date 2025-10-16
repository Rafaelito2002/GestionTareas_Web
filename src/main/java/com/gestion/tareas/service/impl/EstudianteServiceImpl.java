package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.EstudianteDTO;
import com.gestion.tareas.model.Estudiante;
import com.gestion.tareas.repository.EstudianteRepository;
import com.gestion.tareas.services.IEstudianteService;
import com.gestion.tareas.mapper.EstudianteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository repository;
    private final EstudianteMapper mapper;

    @Override
    public EstudianteDTO crear(EstudianteDTO dto) {
        dto.setFechaRegistro(LocalDate.now());
        Estudiante entidad = mapper.toEntity(dto);
        Estudiante guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public EstudianteDTO actualizar(Integer id, EstudianteDTO dto) {
        Estudiante entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setEmail(dto.getEmail());

        Estudiante actualizado = repository.save(entidad);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public EstudianteDTO obtenerPorId(Integer id) {
        Estudiante entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return mapper.toDTO(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstudianteDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}