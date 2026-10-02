package com.loschaskis.sistema_transporte.service;

import com.loschaskis.sistema_transporte.model.Bus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    // Lista que almacena los buses temporalmente en memoria
    private final List<Bus> buses = new ArrayList<>();

    // Variable que permite generar identificadores correlativos
    private Long siguienteId = 1L;

    // Constructor que carga datos iniciales para pruebas
    public BusService() {

        agregar(new Bus(
                null,
                "CHK-201",
                "Mercedes-Benz O500",
                "Confort 160°",
                52,
                "ACTIVO"
        ));

        agregar(new Bus(
                null,
                "CHK-202",
                "Scania K410",
                "Imperial 180°",
                44,
                "ACTIVO"
        ));

        agregar(new Bus(
                null,
                "CHK-203",
                "Volvo B430R",
                "Confort 160°",
                50,
                "MANTENIMIENTO"
        ));
    }

    // Agrega un nuevo bus a la lista en memoria
    public void agregar(Bus bus) {

        bus.setId(siguienteId);

        siguienteId++;

        buses.add(bus);
    }

    // Retorna la lista completa de buses registrados
    public List<Bus> listarTodos() {

        return buses;
    }

    // Busca un bus específico mediante su identificador
    public Optional<Bus> buscarPorId(Long id) {

        return buses.stream()
                .filter(bus -> bus.getId().equals(id))
                .findFirst();
    }

    // Busca buses según placa, modelo, tipo de servicio o estado
    public List<Bus> buscar(String texto) {

        if (texto == null || texto.trim().isEmpty()) {

            return listarTodos();
        }

        String criterio = texto.trim().toLowerCase();

        return buses.stream()
                .filter(bus ->
                        bus.getPlaca().toLowerCase().contains(criterio)
                                ||
                        bus.getModelo().toLowerCase().contains(criterio)
                                ||
                        bus.getTipoServicio().toLowerCase().contains(criterio)
                                ||
                        bus.getEstado().toLowerCase().contains(criterio)
                )
                .toList();
    }

    // Elimina un bus de la lista según su identificador
    public boolean eliminar(Long id) {

        return buses.removeIf(
                bus -> bus.getId().equals(id)
        );
    }
}