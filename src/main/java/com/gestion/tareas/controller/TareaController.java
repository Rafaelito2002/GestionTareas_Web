package com.gestion.tareas.controller;

import com.gestion.tareas.dto.TareaDTO;
import com.gestion.tareas.services.ITareaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class TareaController {

    private final ITareaService service;

    @PostMapping
    public ResponseEntity<TareaDTO> crear(@Valid @RequestBody TareaDTO dto) {
        TareaDTO creado = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<TareaDTO>> obtenerTodos() {
        List<TareaDTO> tareas = service.obtenerTodos();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> obtenerPorId(@PathVariable Integer id) {
        TareaDTO tarea = service.obtenerPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<TareaDTO>> obtenerPorAsignatura(@PathVariable Integer asignaturaId) {
        List<TareaDTO> tareas = service.obtenerPorAsignatura(asignaturaId);
        return ResponseEntity.ok(tareas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody TareaDTO dto) {
        TareaDTO actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}