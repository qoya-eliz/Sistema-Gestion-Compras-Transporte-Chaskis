package com.loschaskis.sistema_transporte.service;

import com.loschaskis.sistema_transporte.model.Ruta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    // Lista que almacena las rutas temporalmente en memoria
    private final List<Ruta> rutas = new ArrayList<>();

    // Variable que permite generar identificadores correlativos
    private Long siguienteId = 1L;

    // Constructor que carga datos iniciales para pruebas
    public RutaService() {

        agregar(new Ruta(
                null,
                "Lima",
                "Piura",
                973.0,
                15,
                120.00,
                "ACTIVA"
        ));

        agregar(new Ruta(
                null,
                "Lima",
                "Chiclayo",
                770.0,
                12,
                95.00,
                "ACTIVA"
        ));

        agregar(new Ruta(
                null,
                "Lima",
                "Cajamarca",
                856.0,
                14,
                110.00,
                "INACTIVA"
        ));
    }

    // Agrega una nueva ruta a la lista en memoria
    public void agregar(Ruta ruta) {

        ruta.setId(siguienteId);

        siguienteId++;

        rutas.add(ruta);
    }

    // Retorna la lista completa de rutas registradas
    public List<Ruta> listarTodos() {

        return rutas;
    }

    // Busca una ruta específica mediante su identificador
    public Optional<Ruta> buscarPorId(Long id) {

        return rutas.stream()
                .filter(ruta -> ruta.getId().equals(id))
                .findFirst();
    }

    // Busca rutas según origen, destino o estado
    public List<Ruta> buscar(String texto) {

        if (texto == null || texto.trim().isEmpty()) {

            return listarTodos();
        }

        String criterio = texto.trim().toLowerCase();

        return rutas.stream()
                .filter(ruta ->
                        ruta.getOrigen().toLowerCase().contains(criterio)
                                ||
                        ruta.getDestino().toLowerCase().contains(criterio)
                                ||
                        ruta.getEstado().toLowerCase().contains(criterio)
                )
                .toList();
    }

    // Elimina una ruta de la lista según su identificador
    public boolean eliminar(Long id) {

        return rutas.removeIf(
                ruta -> ruta.getId().equals(id)
        );
    }
}