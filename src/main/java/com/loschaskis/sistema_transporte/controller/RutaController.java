package com.loschaskis.sistema_transporte.controller;

import com.loschaskis.sistema_transporte.model.Ruta;
import com.loschaskis.sistema_transporte.service.RutaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin/rutas")
public class RutaController {

    // Servicio que contiene la lógica de gestión de rutas
    private final RutaService rutaService;

    // Constructor que permite inyectar el servicio de rutas
    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    // Muestra la lista completa de rutas registradas
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "rutas",
                rutaService.listarTodos()
        );

        model.addAttribute(
                "ruta",
                new Ruta()
        );

        return "admin/rutas/lista";
    }

    // Recibe los datos del formulario y registra una nueva ruta
    @PostMapping("/guardar")
    public String guardar(Ruta ruta) {

        rutaService.agregar(ruta);

        return "redirect:/admin/rutas";
    }

    // Busca rutas según el texto ingresado por el usuario
    @GetMapping("/buscar")
    public String buscar(
            @RequestParam(required = false) String texto,
            Model model) {

        model.addAttribute(
                "rutas",
                rutaService.buscar(texto)
        );

        model.addAttribute(
                "ruta",
                new Ruta()
        );

        model.addAttribute(
                "texto",
                texto
        );

        return "admin/rutas/lista";
    }

    // Consulta una ruta específica mediante su identificador
    @GetMapping("/consultar")
    public String consultar(
            @RequestParam Long id,
            Model model) {

        Optional<Ruta> rutaConsultada =
                rutaService.buscarPorId(id);

        model.addAttribute(
                "rutas",
                rutaService.listarTodos()
        );

        model.addAttribute(
                "ruta",
                new Ruta()
        );

        rutaConsultada.ifPresent(
                ruta -> model.addAttribute(
                        "rutaConsultada",
                        ruta
                )
        );

        return "admin/rutas/lista";
    }

    // Elimina una ruta mediante su identificador
    @PostMapping("/eliminar")
    public String eliminar(
            @RequestParam Long id) {

        rutaService.eliminar(id);

        return "redirect:/admin/rutas";
    }
}