package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Actividad;
import com.eoi.grupo5.modelos.Habitacion;
import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.modelos.Precio;
import com.eoi.grupo5.repos.RepoActividad;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ServicioActividad extends AbstractBusinessServiceSoloEnt<Actividad, Integer, RepoActividad>{

    protected ServicioActividad(RepoActividad repoActividad) {
        super(repoActividad);
    }

    public List<Actividad> obtenerActividadesEnTuZona(Actividad actividad) {
        return super.buscarEntidades()
                .stream()
                .filter(a -> a.getLocalizacion().getNombre().equals(actividad.getLocalizacion().getNombre()) && !Objects.equals(a.getId(), actividad.getId()))
                .limit(2)
                .toList();
    }


    public Precio getPrecioActual(Actividad actividad, LocalDateTime fechaActual) {
        return actividad.getPrecio().stream()
                .filter(precio -> !fechaActual.isBefore(precio.getFechaInicio()) && (precio.getFechaFin() == null || !fechaActual.isAfter(precio.getFechaFin())))
                .findFirst()
                .orElse(null);
    }

    public Map<Integer, Double> obtenerPreciosActualesActividades(List<Actividad> actividades) {
        // Obtener los precios actuales de las actividades del hotel
        LocalDateTime fechaActual = LocalDateTime.now();
        Map<Integer, Double> preciosActuales = new HashMap<>();

        actividades.forEach(actividad -> {
            Precio precioActual = getPrecioActual(actividad, fechaActual);
            if (precioActual != null) {
                preciosActuales.put(actividad.getId(), precioActual.getPrecio());
            } else {
                preciosActuales.put(actividad.getId(), null);
            }
        });

        return preciosActuales;
    }

}
