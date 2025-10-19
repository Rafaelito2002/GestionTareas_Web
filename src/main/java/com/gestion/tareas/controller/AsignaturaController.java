package com.gestion.tareas.controller;

import com.gestion.tareas.dto.AsignaturaDTO;
import com.gestion.tareas.services.IAsignaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class AsignaturaController {

    private final IAsignaturaService service;

    @PostMapping
    public ResponseEntity<AsignaturaDTO> crear(@Valid @RequestBody AsignaturaDTO dto) {
        AsignaturaDTO creado = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> obtenerTodos() {
        List<AsignaturaDTO> asignaturas = service.obtenerTodos();
        return ResponseEntity.ok(asignaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerPorId(@PathVariable Integer id) {
        AsignaturaDTO asignatura = service.obtenerPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    @GetMapping("/docente/{docenteId}")
    public ResponseEntity<List<AsignaturaDTO>> obtenerPorDocente(@PathVariable Integer docenteId) {
        List<AsignaturaDTO> asignaturas = service.obtenerPorDocente(docenteId);
        return ResponseEntity.ok(asignaturas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody AsignaturaDTO dto) {
        AsignaturaDTO actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}