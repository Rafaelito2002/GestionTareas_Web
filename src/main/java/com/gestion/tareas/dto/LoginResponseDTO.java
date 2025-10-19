package com.gestion.tareas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private Integer id;
    private String username;
    private String tipoUsuario;
    private Integer usuarioId;
    private String mensaje;
    private boolean exito;

    // Constructor para respuesta exitosa
    public LoginResponseDTO(Integer id, String username, String tipoUsuario, Integer usuarioId) {
        this.id = id;
        this.username = username;
        this.tipoUsuario = tipoUsuario;
        this.usuarioId = usuarioId;
        this.mensaje = "Login exitoso";
        this.exito = true;
    }

    // Constructor para respuesta de error
    public LoginResponseDTO(String mensaje) {
        this.mensaje = mensaje;
        this.exito = false;
    }
}