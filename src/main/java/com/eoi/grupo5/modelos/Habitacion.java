package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "habitaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="numero", nullable = false)
    private Integer numero;

    @Column(name="capacidad")
    private Byte capacidad;

    @Column(name = "numeroCamas")
    private Byte numeroCamas;

    @ManyToOne
    @JoinColumn(name = "idTipo", foreignKey = @ForeignKey(name = "fkHabitacionesTipo"), nullable = false)
    private TipoHabitacion tipo;

    @ManyToOne
    @JoinColumn(name = "idHotel", foreignKey = @ForeignKey(name = "fkHabitacionesHoteles"), nullable = false)
    private Hotel hotel;

    @OneToMany(mappedBy = "habitacion")
    private Set<HabitacionReservada> habitacionesReservadas = new HashSet<>();

    @OneToMany(mappedBy = "habitacionImagen",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Imagen> imagenesHabitacion = new HashSet<>();

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Precio> precio = new HashSet<>();

}
