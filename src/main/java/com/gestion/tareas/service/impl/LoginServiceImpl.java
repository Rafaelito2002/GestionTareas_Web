package com.gestion.tareas.service.impl;

import com.gestion.tareas.dto.LoginDTO;
import com.gestion.tareas.dto.LoginResponseDTO;
import com.gestion.tareas.mapper.UsuarioMapper;
import com.gestion.tareas.model.Usuario;
import com.gestion.tareas.repository.UsuarioRepository;
import com.gestion.tareas.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public LoginResponseDTO autenticar(LoginDTO loginDTO) {
        // Buscar usuario por username y password
        Optional<Usuario> usuarioOpt = usuarioRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuarioMapper.toLoginResponseDTO(usuario);
        } else {
            return new LoginResponseDTO("Credenciales inválidas. Usuario o contraseña incorrectos.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validarCredenciales(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password).isPresent();
    }
}