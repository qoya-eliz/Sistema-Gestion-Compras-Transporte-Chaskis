package com.loschaskis.sistema_transporte.controller;

import com.loschaskis.sistema_transporte.model.Bus;
import com.loschaskis.sistema_transporte.service.BusService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin/buses")
public class BusController {

    // Servicio que contiene la lógica de gestión de buses
    private final BusService busService;

    // Constructor que permite inyectar el servicio de buses
    public BusController(BusService busService) {
        this.busService = busService;
    }

    // Muestra la lista completa de buses registrados
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "buses",
                busService.listarTodos()
        );

        model.addAttribute(
                "bus",
                new Bus()
        );

        return "admin/buses/lista";
    }

    // Recibe los datos del formulario y registra un nuevo bus
    @PostMapping("/guardar")
    public String guardar(Bus bus) {

        busService.agregar(bus);

        return "redirect:/admin/buses";
    }

    // Busca buses según el texto ingresado por el usuario
    @GetMapping("/buscar")
    public String buscar(
            @RequestParam(required = false) String texto,
            Model model) {

        model.addAttribute(
                "buses",
                busService.buscar(texto)
        );

        model.addAttribute(
                "bus",
                new Bus()
        );

        model.addAttribute(
                "texto",
                texto
        );

        return "admin/buses/lista";
    }

    // Consulta un bus específico mediante su identificador
    @GetMapping("/consultar")
    public String consultar(
            @RequestParam Long id,
            Model model) {

        Optional<Bus> busConsultado =
                busService.buscarPorId(id);

        model.addAttribute(
                "buses",
                busService.listarTodos()
        );

        model.addAttribute(
                "bus",
                new Bus()
        );

        busConsultado.ifPresent(
                bus -> model.addAttribute(
                        "busConsultado",
                        bus
                )
        );

        return "admin/buses/lista";
    }

    // Elimina un bus mediante su identificador
    @PostMapping("/eliminar")
    public String eliminar(
            @RequestParam Long id) {

        busService.eliminar(id);

        return "redirect:/admin/buses";
    }
}