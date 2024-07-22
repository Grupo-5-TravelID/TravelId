package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fechaSalida")
    private LocalDateTime fechaSalida;

    @Column(name = "fechaLlegada")
    private LocalDateTime fechaLlegada;

    @ManyToOne
    @JoinColumn(name = "idCompania", foreignKey = @ForeignKey(name = "fkVuelosCompanias"), nullable = false)
    private CompaniaVuelo compania;

    @ManyToOne
    @JoinColumn(name = "idOrigen", foreignKey = @ForeignKey(name = "fkVuelosOrigen"), nullable = false)
    private Localizacion origen;

    @ManyToOne
    @JoinColumn(name = "idDestino", foreignKey = @ForeignKey(name = "fkVuelosDestino"), nullable = false)
    private Localizacion destino;

    @OneToMany(mappedBy = "vuelo")
    private Set<Asiento> asientos = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "idImagen")
    private Imagen imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

}
