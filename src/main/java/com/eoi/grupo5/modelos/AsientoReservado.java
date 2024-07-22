package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "asientosReservados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsientoReservado {

    @EmbeddedId
    private AsientoReservadoId id;

    @ManyToOne
    @MapsId("idAsiento")
    @JoinColumn(name = "idAsiento")
    private Asiento asiento;

    @ManyToOne
    @MapsId("idReserva")
    @JoinColumn(name = "idReserva")
    private Reserva reserva;

    @Column(name = "fechaVuelo")
    private LocalDateTime fechaVuelo;

    @Column(name = "horaVuelo")
    private LocalDateTime horaVuelo;

}
