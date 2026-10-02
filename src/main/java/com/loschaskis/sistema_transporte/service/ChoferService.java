package com.loschaskis.sistema_transporte.service;

import com.loschaskis.sistema_transporte.model.Chofer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChoferService {

    // Lista que almacena los choferes temporalmente en memoria
    private final List<Chofer> choferes = new ArrayList<>();

    // Variable si ya que permite generar identificadores correlativos
    private Long siguienteId = 1L;

    // Constructor que carga datos iniciales para pruebas
    public ChoferService() {

        agregar(new Chofer(
                null,
                "45871236",
                "Carlos",
                "Mendoza Ruiz",
                "AIIIc-458721",
                "987654321",
                "ACTIVO"
        ));

        agregar(new Chofer(
                null,
                "47258963",
                "Luis",
                "Ramírez Soto",
                "AIIIc-472589",
                "986321547",
                "ACTIVO"
        ));

        agregar(new Chofer(
                null,
                "43698521",
                "Jorge",
                "Salazar Vega",
                "AIIIc-436985",
                "985147263",
                "INACTIVO"
        ));
    }

    // Agrega un nuevo chofer a la lista en memoria
    public void agregar(Chofer chofer) {

        chofer.setId(siguienteId);
        siguienteId++;

        choferes.add(chofer);
    }

    // Retorna la lista completa de choferes registrados
    public List<Chofer> listarTodos() {

        return choferes;
    }

    // Busca un chofer específico mediante su identificador
    public Optional<Chofer> buscarPorId(Long id) {

        return choferes.stream()
                .filter(chofer -> chofer.getId().equals(id))
                .findFirst();
    }

    // Busca choferes según DNI, nombres, apellidos, licencia o estado
    public List<Chofer> buscar(String texto) {

        if (texto == null || texto.trim().isEmpty()) {
            return listarTodos();
        }

        String criterio = texto.trim().toLowerCase();

        return choferes.stream()
                .filter(chofer ->
                        chofer.getDni().toLowerCase().contains(criterio)
                                || chofer.getNombres().toLowerCase().contains(criterio)
                                || chofer.getApellidos().toLowerCase().contains(criterio)
                                || chofer.getLicencia().toLowerCase().contains(criterio)
                                || chofer.getEstado().toLowerCase().contains(criterio)
                )
                .toList();
    }

    // Elimina un chofer de la lista según su identificador
    public boolean eliminar(Long id) {

        return choferes.removeIf(
                chofer -> chofer.getId().equals(id)
        );
    }
}