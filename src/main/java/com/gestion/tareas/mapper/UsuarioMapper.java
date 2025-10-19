package com.gestion.tareas.mapper;

import com.gestion.tareas.dto.LoginResponseDTO;
import com.gestion.tareas.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public LoginResponseDTO toLoginResponseDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new LoginResponseDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getTipoUsuario().name(),
                usuario.getUsuarioId()
        );
    }
}