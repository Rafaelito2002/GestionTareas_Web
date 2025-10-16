package com.gestion.tareas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDTO {

    private Integer id;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer estudianteId;

    @NotNull(message = "El ID de la tarea es obligatorio")
    private Integer tareaId;

    @NotNull(message = "La fecha de entrega es obligatoria")
    private LocalDate fechaEntrega;

    private String archivo;

    private BigDecimal calificacion;

    private String estudianteNombre;
    private String estudianteApellido;
    private String tareaNombre;
    private String asignaturaNombre;
}
