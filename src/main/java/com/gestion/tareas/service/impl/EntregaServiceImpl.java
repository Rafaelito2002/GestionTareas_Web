package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.EntregaDTO;
import com.gestion.tareas.model.Entrega;
import com.gestion.tareas.model.Estudiante;
import com.gestion.tareas.model.Tarea;
import com.gestion.tareas.repository.EntregaRepository;
import com.gestion.tareas.repository.EstudianteRepository;
import com.gestion.tareas.repository.TareaRepository;
import com.gestion.tareas.services.IEntregaService;
import com.gestion.tareas.mapper.EntregaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EntregaServiceImpl implements IEntregaService {

    private final EntregaRepository repository;
    private final EstudianteRepository estudianteRepository;
    private final TareaRepository tareaRepository;
    private final EntregaMapper mapper;

    @Override
    public EntregaDTO crear(EntregaDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Tarea tarea = tareaRepository.findById(dto.getTareaId())
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        Entrega entidad = mapper.toEntity(dto);
        entidad.setEstudiante(estudiante);
        entidad.setTarea(tarea);

        Entrega guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public EntregaDTO actualizar(Integer id, EntregaDTO dto) {
        Entrega entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));

        entidad.setFechaEntrega(dto.getFechaEntrega());
        entidad.setArchivo(dto.getArchivo());
        entidad.setCalificacion(dto.getCalificacion());

        Entrega actualizado = repository.save(entidad);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entrega no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public EntregaDTO obtenerPorId(Integer id) {
        Entrega entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
        return mapper.toDTO(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntregaDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntregaDTO> obtenerPorTarea(Integer tareaId) {
        return repository.findByTareaId(tareaId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntregaDTO> obtenerPorEstudiante(Integer estudianteId) {
        return repository.findByEstudianteId(estudianteId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}