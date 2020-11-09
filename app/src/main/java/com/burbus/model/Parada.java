package com.burbus.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Parada implements Serializable {

    @SerializedName("linea")
    private String linea;
    @SerializedName("id")
    private String id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("sentido")
    private String sentido;
    @SerializedName("lineaActiva")
    private String lineaActiva;

    public Parada(String linea, String id, String nombre, String lat, String lon, String sentido, String lineaActiva){
        this.linea = linea;
        this.id = id;
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.sentido = sentido;
        this.lineaActiva = lineaActiva;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public String getLineaActiva() {
        return lineaActiva;
    }

    public void setLineaActiva(String lineaActiva) {
        this.lineaActiva = lineaActiva;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if(o instanceof Parada){
            if (((Parada) o).id.equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
