package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hoteles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "categoria")
    private Byte categoria;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "contacto", length = 45)
    private String contacto;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Habitacion> habitaciones = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idLocalizacion", foreignKey = @ForeignKey(name = "fkHotelesLocal"))
    private Localizacion localizacion;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Imagen> imagenesHotel = new HashSet<>();

}
