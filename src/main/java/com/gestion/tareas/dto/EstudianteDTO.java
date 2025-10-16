package com.gestion.tareas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

// DTO siguiendo Single Responsibility Principle (SRP)
// Solo responsable de transferir datos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {

    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    private LocalDate fechaRegistro;
}