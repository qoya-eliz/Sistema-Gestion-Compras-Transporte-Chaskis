package com.loschaskis.sistema_transporte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    // Muestra el portal principal
    @GetMapping("/")
    public String inicio() {
        return "portal/inicio";
    }

    // Muestra el login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Muestra el buscador
    @GetMapping("/buscar")
    public String buscar() {
        return "portal/buscar";
    }

    // Muestra los resultados
    @GetMapping("/resultados")
    public String resultados() {
        return "portal/resultados";
    }

    // Muestra la selección de asientos
    @GetMapping("/asientos")
    public String asientos() {
        return "portal/asientos";
    }

    // Muestra los datos de pasajeros
    @GetMapping("/pasajeros")
    public String pasajeros() {
        return "portal/pasajeros";
    }

    // Muestra el pago
    @GetMapping("/pago")
    public String pago() {
        return "portal/pago";
    }

    // Muestra la confirmación
    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "portal/confirmacion";
    }

    // Muestra el dashboard del supervisor
    @GetMapping("/supervisor/dashboard")
    public String supervisorDashboard() {
        return "supervisor/dashboard";
    }

    // Muestra el control de embarque
    @GetMapping("/supervisor/embarque")
    public String embarque() {
        return "supervisor/embarque";
    }

    // Muestra el plano de asientos
    @GetMapping("/supervisor/plano-asientos")
    public String planoAsientos() {
        return "supervisor/plano-asientos";
    }
}