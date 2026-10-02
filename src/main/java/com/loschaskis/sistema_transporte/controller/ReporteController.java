package com.loschaskis.sistema_transporte.controller;

import com.loschaskis.sistema_transporte.service.BusService;
import com.loschaskis.sistema_transporte.service.ChoferService;
import com.loschaskis.sistema_transporte.service.RutaService;
import com.loschaskis.sistema_transporte.service.ViajeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ReporteController {

    // Servicios utilizados para obtener los datos del sistema
    private final BusService busService;
    private final ChoferService choferService;
    private final RutaService rutaService;
    private final ViajeService viajeService;

    // Constructor que permite inyectar los servicios necesarios
    public ReporteController(BusService busService,
                             ChoferService choferService,
                             RutaService rutaService,
                             ViajeService viajeService) {

        this.busService = busService;
        this.choferService = choferService;
        this.rutaService = rutaService;
        this.viajeService = viajeService;
    }

    // Muestra el dashboard principal con indicadores y gráficos
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Indicadores generales
        model.addAttribute(
                "totalBuses",
                busService.listarTodos().size()
        );

        model.addAttribute(
                "totalChoferes",
                choferService.listarTodos().size()
        );

        model.addAttribute(
                "totalRutas",
                rutaService.listarTodos().size()
        );

        model.addAttribute(
                "totalViajes",
                viajeService.listarTodos().size()
        );

        // Datos para gráfico circular de estado de buses
        long busesActivos = busService.listarTodos()
                .stream()
                .filter(bus -> "ACTIVO".equalsIgnoreCase(bus.getEstado()))
                .count();

        long busesMantenimiento = busService.listarTodos()
                .stream()
                .filter(bus -> "MANTENIMIENTO".equalsIgnoreCase(bus.getEstado()))
                .count();

        long busesInactivos = busService.listarTodos()
                .stream()
                .filter(bus -> "INACTIVO".equalsIgnoreCase(bus.getEstado()))
                .count();

        model.addAttribute("busesActivos", busesActivos);
        model.addAttribute("busesMantenimiento", busesMantenimiento);
        model.addAttribute("busesInactivos", busesInactivos);

        // Datos para gráfico circular de estado de viajes
        long viajesProgramados = viajeService.listarTodos()
                .stream()
                .filter(viaje -> "PROGRAMADO".equalsIgnoreCase(viaje.getEstado()))
                .count();

        long viajesCancelados = viajeService.listarTodos()
                .stream()
                .filter(viaje -> "CANCELADO".equalsIgnoreCase(viaje.getEstado()))
                .count();

        model.addAttribute("viajesProgramados", viajesProgramados);
        model.addAttribute("viajesCancelados", viajesCancelados);

        return "admin/dashboard";
    }

    // Muestra la segunda página con reportes detallados
    @GetMapping("/reportes")
    public String reportes(Model model) {

        // Cantidad de buses por tipo de servicio
        long busesConfort = busService.listarTodos()
                .stream()
                .filter(bus -> "Confort 160°".equalsIgnoreCase(bus.getTipoServicio()))
                .count();

        long busesImperial = busService.listarTodos()
                .stream()
                .filter(bus -> "Imperial 180°".equalsIgnoreCase(bus.getTipoServicio()))
                .count();

        model.addAttribute("busesConfort", busesConfort);
        model.addAttribute("busesImperial", busesImperial);

        // Cantidad de viajes por destino
        long viajesPiura = viajeService.listarTodos()
                .stream()
                .filter(viaje -> "Piura".equalsIgnoreCase(viaje.getDestino()))
                .count();

        long viajesChiclayo = viajeService.listarTodos()
                .stream()
                .filter(viaje -> "Chiclayo".equalsIgnoreCase(viaje.getDestino()))
                .count();

        long viajesCajamarca = viajeService.listarTodos()
                .stream()
                .filter(viaje -> "Cajamarca".equalsIgnoreCase(viaje.getDestino()))
                .count();

        model.addAttribute("viajesPiura", viajesPiura);
        model.addAttribute("viajesChiclayo", viajesChiclayo);
        model.addAttribute("viajesCajamarca", viajesCajamarca);

        return "admin/reportes/detalle";
    }
}