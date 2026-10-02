package com.loschaskis.sistema_transporte.controller;

import com.loschaskis.sistema_transporte.model.Viaje;
import com.loschaskis.sistema_transporte.service.ViajeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin/viajes")
public class ViajeController {

    // Servicio que contiene la lógica de gestión de viajes
    private final ViajeService viajeService;

    // Constructor que permite inyectar el servicio de viajes
    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    // Muestra la lista completa de viajes registrados
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "viajes",
                viajeService.listarTodos()
        );

        model.addAttribute(
                "viaje",
                new Viaje()
        );

        return "admin/viajes/lista";
    }

    // Recibe los datos del formulario y registra un nuevo viaje
    @PostMapping("/guardar")
    public String guardar(Viaje viaje) {

        viajeService.agregar(viaje);

        return "redirect:/admin/viajes";
    }

    // Busca viajes según el texto ingresado por el usuario
    @GetMapping("/buscar")
    public String buscar(
            @RequestParam(required = false) String texto,
            Model model) {

        model.addAttribute(
                "viajes",
                viajeService.buscar(texto)
        );

        model.addAttribute(
                "viaje",
                new Viaje()
        );

        model.addAttribute(
                "texto",
                texto
        );

        return "admin/viajes/lista";
    }

    // Consulta un viaje específico mediante su identificador
    @GetMapping("/consultar")
    public String consultar(
            @RequestParam Long id,
            Model model) {

        Optional<Viaje> viajeConsultado =
                viajeService.buscarPorId(id);

        model.addAttribute(
                "viajes",
                viajeService.listarTodos()
        );

        model.addAttribute(
                "viaje",
                new Viaje()
        );

        viajeConsultado.ifPresent(
                viaje -> model.addAttribute(
                        "viajeConsultado",
                        viaje
                )
        );

        return "admin/viajes/lista";
    }

    // Elimina un viaje mediante su identificador
    @PostMapping("/eliminar")
    public String eliminar(
            @RequestParam Long id) {

        viajeService.eliminar(id);

        return "redirect:/admin/viajes";
    }
}