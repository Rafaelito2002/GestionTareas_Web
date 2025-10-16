package com.gestion.tareas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Entregas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(length = 255)
    private String archivo;

    @Column(precision = 5, scale = 2)
    private BigDecimal calificacion;
}
