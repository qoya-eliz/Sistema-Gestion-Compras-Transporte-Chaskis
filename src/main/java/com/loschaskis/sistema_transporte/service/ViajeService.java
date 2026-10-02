package com.loschaskis.sistema_transporte.service;

import com.loschaskis.sistema_transporte.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {

    // Lista que almacena los viajes temporalmente en memoria
    private final List<Viaje> viajes = new ArrayList<>();

    // Variable que permite generar identificadores correlativos
    private Long siguienteId = 1L;

    // Constructor que carga datos iniciales para pruebas
    public ViajeService() {

        agregar(new Viaje(
                null,
                "VJ-001",
                "Lima",
                "Piura",
                "2026-10-10",
                "20:00",
                "CHK-201",
                "Carlos Mendoza Ruiz",
                "PROGRAMADO"
        ));

        agregar(new Viaje(
                null,
                "VJ-002",
                "Lima",
                "Chiclayo",
                "2026-10-11",
                "21:30",
                "CHK-202",
                "Luis Ramírez Soto",
                "PROGRAMADO"
        ));

        agregar(new Viaje(
                null,
                "VJ-003",
                "Lima",
                "Cajamarca",
                "2026-10-12",
                "19:00",
                "CHK-203",
                "Jorge Salazar Vega",
                "CANCELADO"
        ));
    }

    // Agrega un nuevo viaje a la lista en memoria
    public void agregar(Viaje viaje) {

        viaje.setId(siguienteId);

        siguienteId++;

        viajes.add(viaje);
    }

    // Retorna la lista completa de viajes registrados
    public List<Viaje> listarTodos() {

        return viajes;
    }

    // Busca un viaje específico mediante su identificador
    public Optional<Viaje> buscarPorId(Long id) {

        return viajes.stream()
                .filter(viaje -> viaje.getId().equals(id))
                .findFirst();
    }

    // Busca viajes según código, origen, destino, bus, chofer o estado
    public List<Viaje> buscar(String texto) {

        if (texto == null || texto.trim().isEmpty()) {

            return listarTodos();
        }

        String criterio = texto.trim().toLowerCase();

        return viajes.stream()
                .filter(viaje ->
                        viaje.getCodigoViaje().toLowerCase().contains(criterio)
                                ||
                        viaje.getOrigen().toLowerCase().contains(criterio)
                                ||
                        viaje.getDestino().toLowerCase().contains(criterio)
                                ||
                        viaje.getPlacaBus().toLowerCase().contains(criterio)
                                ||
                        viaje.getChofer().toLowerCase().contains(criterio)
                                ||
                        viaje.getEstado().toLowerCase().contains(criterio)
                )
                .toList();
    }

    // Elimina un viaje de la lista según su identificador
    public boolean eliminar(Long id) {

        return viajes.removeIf(
                viaje -> viaje.getId().equals(id)
        );
    }
}