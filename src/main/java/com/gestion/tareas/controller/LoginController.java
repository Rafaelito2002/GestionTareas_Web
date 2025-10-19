package com.gestion.tareas.controller;

import com.gestion.tareas.dto.LoginDTO;
import com.gestion.tareas.dto.LoginResponseDTO;
import com.gestion.tareas.services.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO,
                                   BindingResult bindingResult) {

        // Validar errores de entrada
        if (bindingResult.hasErrors()) {
            Map<String, String> errores = bindingResult.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                            error -> error.getField(),
                            error -> error.getDefaultMessage()
                    ));

            Map<String, Object> response = new HashMap<>();
            response.put("exito", false);
            response.put("errores", errores);
            response.put("mensaje", "Error en la validación de datos");

            return ResponseEntity.badRequest().body(response);
        }

        // Autenticar usuario
        LoginResponseDTO loginResponse = loginService.autenticar(loginDTO);

        if (loginResponse.isExito()) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }

    @GetMapping("/validar")
    public ResponseEntity<Map<String, Boolean>> validarCredenciales(
            @RequestParam String username,
            @RequestParam String password) {

        boolean valido = loginService.validarCredenciales(username, password);

        Map<String, Boolean> response = new HashMap<>();
        response.put("valido", valido);

        return ResponseEntity.ok(response);
    }
}