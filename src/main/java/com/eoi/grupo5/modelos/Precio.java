package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "idAsiento")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "idActividad")
    private Actividad actividad;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}
