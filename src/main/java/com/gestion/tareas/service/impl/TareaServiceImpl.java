package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.TareaDTO;
import com.gestion.tareas.model.Tarea;
import com.gestion.tareas.model.Asignatura;
import com.gestion.tareas.repository.TareaRepository;
import com.gestion.tareas.repository.AsignaturaRepository;
import com.gestion.tareas.services.ITareaService;
import com.gestion.tareas.mapper.TareaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TareaServiceImpl implements ITareaService {

    private final TareaRepository repository;
    private final AsignaturaRepository asignaturaRepository;
    private final TareaMapper mapper;

    @Override
    public TareaDTO crear(TareaDTO dto) {
        Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        Tarea entidad = mapper.toEntity(dto);
        entidad.setAsignatura(asignatura);

        Tarea guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public TareaDTO actualizar(Integer id, TareaDTO dto) {
        Tarea entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setFechaEntrega(dto.getFechaEntrega());

        if (dto.getAsignaturaId() != null) {
            Asignatura asignatura = asignaturaRepository.findById(dto.getAsignaturaId())
                    .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
            entidad.setAsignatura(asignatura);
        }

        Tarea actualizado = repository.save(entidad);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TareaDTO obtenerPorId(Integer id) {
        Tarea entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        return mapper.toDTO(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TareaDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TareaDTO> obtenerPorAsignatura(Integer asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}