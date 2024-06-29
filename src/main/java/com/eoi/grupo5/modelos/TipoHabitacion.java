package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_habitacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "precioNoche")
    private Double precioNoche;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @OneToMany(mappedBy = "tipo")
    private Set<Habitacion> habitaciones = new HashSet<>();

}