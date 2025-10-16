package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.AsignaturaDTO;
import com.gestion.tareas.model.Asignatura;
import com.gestion.tareas.model.Docente;
import com.gestion.tareas.repository.AsignaturaRepository;
import com.gestion.tareas.repository.DocenteRepository;
import com.gestion.tareas.services.IAsignaturaService;
import com.gestion.tareas.mapper.AsignaturaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AsignaturaServiceImpl implements IAsignaturaService {

    private final AsignaturaRepository repository;
    private final DocenteRepository docenteRepository;
    private final AsignaturaMapper mapper;

    @Override
    public AsignaturaDTO crear(AsignaturaDTO dto) {
        Docente docente = docenteRepository.findById(dto.getDocenteId())
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        Asignatura entidad = mapper.toEntity(dto);
        entidad.setDocente(docente);

        Asignatura guardado = repository.save(entidad);
        return mapper.toDTO(guardado);
    }

    @Override
    public AsignaturaDTO actualizar(Integer id, AsignaturaDTO dto) {
        Asignatura entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        entidad.setNombre(dto.getNombre());
        entidad.setDescripcion(dto.getDescripcion());

        if (dto.getDocenteId() != null) {
            Docente docente = docenteRepository.findById(dto.getDocenteId())
                    .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
            entidad.setDocente(docente);
        }

        Asignatura actualizado = repository.save(entidad);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Asignatura no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public AsignaturaDTO obtenerPorId(Integer id) {
        Asignatura entidad = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
        return mapper.toDTO(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> obtenerPorDocente(Integer docenteId) {
        return repository.findByDocenteId(docenteId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
