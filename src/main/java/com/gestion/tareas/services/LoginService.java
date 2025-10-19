package com.gestion.tareas.services;

import com.gestion.tareas.dto.LoginDTO;
import com.gestion.tareas.dto.LoginResponseDTO;

public interface LoginService {

    LoginResponseDTO autenticar(LoginDTO loginDTO);

    boolean validarCredenciales(String username, String password);
}