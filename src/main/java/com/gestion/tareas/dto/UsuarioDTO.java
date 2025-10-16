package com.gestion.tareas.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotBlank(message = "El username es obligatorio")
    private String username;

    @NotBlank(message = "El password es obligatorio")
    private String password;

    @NotBlank(message = "El tipo de usuario es obligatorio")
    private String tipoUsuario; // "estudiante" o "docente"

    @NotNull(message = "El ID del usuario relacionado es obligatorio")
    private Integer usuarioId;
}