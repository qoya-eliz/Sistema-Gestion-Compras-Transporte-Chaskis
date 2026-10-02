package com.loschaskis.sistema_transporte.model;

public class Bus {

    private Long id;
    private String placa;
    private String modelo;
    private String tipoServicio;
    private int capacidadAsientos;
    private String estado;

    // Constructor vacío
    public Bus() {
    }

    // Constructor con parámetros
    public Bus(Long id, String placa, String modelo,
               String tipoServicio, int capacidadAsientos,
               String estado) {

        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.tipoServicio = tipoServicio;
        this.capacidadAsientos = capacidadAsientos;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getCapacidadAsientos() {
        return capacidadAsientos;
    }

    public void setCapacidadAsientos(int capacidadAsientos) {
        this.capacidadAsientos = capacidadAsientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}