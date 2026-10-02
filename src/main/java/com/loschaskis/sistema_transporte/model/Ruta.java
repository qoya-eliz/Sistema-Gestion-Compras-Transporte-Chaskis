package com.loschaskis.sistema_transporte.model;

public class Ruta {

    private Long id;
    private String origen;
    private String destino;
    private double distanciaKm;
    private int duracionHoras;
    private double precioBase;
    private String estado;

    public Ruta() {
    }

    public Ruta(Long id, String origen, String destino,
                double distanciaKm, int duracionHoras,
                double precioBase, String estado) {

        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.duracionHoras = duracionHoras;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}