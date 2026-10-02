package com.loschaskis.sistema_transporte.controller;

import com.loschaskis.sistema_transporte.model.Chofer;
import com.loschaskis.sistema_transporte.service.ChoferService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/admin/choferes")
public class ChoferController {

    // Servicio que contiene la lógica de gestión de choferes
    private final ChoferService choferService;

    // Constructor que permite inyectar el servicio de choferes
    public ChoferController(ChoferService choferService) {
        this.choferService = choferService;
    }

    // Muestra la lista completa de choferes registrados
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "choferes",
                choferService.listarTodos()
        );

        model.addAttribute(
                "chofer",
                new Chofer()
        );

        return "admin/choferes/lista";
    }

    // Recibe los datos del formulario y registra un nuevo chofer
    @PostMapping("/guardar")
    public String guardar(Chofer chofer) {

        choferService.agregar(chofer);

        return "redirect:/admin/choferes";
    }

    // Busca choferes según el texto ingresado por el usuario
    @GetMapping("/buscar")
    public String buscar(
            @RequestParam(required = false) String texto,
            Model model) {

        model.addAttribute(
                "choferes",
                choferService.buscar(texto)
        );

        model.addAttribute(
                "chofer",
                new Chofer()
        );

        model.addAttribute(
                "texto",
                texto
        );

        return "admin/choferes/lista";
    }

    // Consulta un chofer específico mediante su identificador
    @GetMapping("/consultar")
    public String consultar(
            @RequestParam Long id,
            Model model) {

        Optional<Chofer> choferConsultado =
                choferService.buscarPorId(id);

        model.addAttribute(
                "choferes",
                choferService.listarTodos()
        );

        model.addAttribute(
                "chofer",
                new Chofer()
        );

        choferConsultado.ifPresent(
                chofer -> model.addAttribute(
                        "choferConsultado",
                        chofer
                )
        );

        return "admin/choferes/lista";
    }

    // Elimina un chofer mediante su identificador
    @PostMapping("/eliminar")
    public String eliminar(
            @RequestParam Long id) {

        choferService.eliminar(id);

        return "redirect:/admin/choferes";
    }
}