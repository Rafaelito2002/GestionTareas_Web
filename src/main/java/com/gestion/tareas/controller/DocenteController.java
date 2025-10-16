package com.gestion.tareas.controller;

import com.gestion.tareas.dto.DocenteDTO;
import com.gestion.tareas.services.IDocenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteController {

    private final IDocenteService service;

    @PostMapping
    public ResponseEntity<DocenteDTO> crear(@Valid @RequestBody DocenteDTO dto) {
        DocenteDTO creado = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<DocenteDTO>> obtenerTodos() {
        List<DocenteDTO> docentes = service.obtenerTodos();
        return ResponseEntity.ok(docentes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteDTO> obtenerPorId(@PathVariable Integer id) {
        DocenteDTO docente = service.obtenerPorId(id);
        return ResponseEntity.ok(docente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody DocenteDTO dto) {
        DocenteDTO actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}