package com.gestion.tareas.controller;

import com.gestion.tareas.dto.EntregaDTO;
import com.gestion.tareas.services.IEntregaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entregas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class EntregaController {

    private final IEntregaService service;

    @PostMapping
    public ResponseEntity<EntregaDTO> crear(@Valid @RequestBody EntregaDTO dto) {
        EntregaDTO creado = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<EntregaDTO>> obtenerTodos() {
        List<EntregaDTO> entregas = service.obtenerTodos();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaDTO> obtenerPorId(@PathVariable Integer id) {
        EntregaDTO entrega = service.obtenerPorId(id);
        return ResponseEntity.ok(entrega);
    }

    @GetMapping("/tarea/{tareaId}")
    public ResponseEntity<List<EntregaDTO>> obtenerPorTarea(@PathVariable Integer tareaId) {
        List<EntregaDTO> entregas = service.obtenerPorTarea(tareaId);
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<EntregaDTO>> obtenerPorEstudiante(@PathVariable Integer estudianteId) {
        List<EntregaDTO> entregas = service.obtenerPorEstudiante(estudianteId);
        return ResponseEntity.ok(entregas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregaDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody EntregaDTO dto) {
        EntregaDTO actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}