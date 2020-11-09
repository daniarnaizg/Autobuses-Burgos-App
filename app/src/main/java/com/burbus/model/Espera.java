package com.burbus.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Espera {

    @SerializedName("id")
    private String id;
    @SerializedName("linea")
    private String linea;
    @SerializedName("estimaciones")
    private List<String> estimaciones;
    @SerializedName("lineaActiva")
    private String lineaActiva;

    public Espera(String id, String linea, List<String> estimaciones, String lineaActiva) {
        this.id = id;
        this.linea = linea;
        this.estimaciones = estimaciones;
        this.lineaActiva = lineaActiva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public List<String> getEstimaciones() {
        return estimaciones;
    }

    public void setEstimaciones(List<String> estimaciones) {
        this.estimaciones = estimaciones;
    }

    public String getLineaActiva() {
        return lineaActiva;
    }

    public void setLineaActiva(String lineaActiva) {
        this.lineaActiva = lineaActiva;
    }
}
