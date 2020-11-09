package com.burbus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehiculo implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("linea")
    private String linea;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("sentido")
    private String sentido;

    public Vehiculo(String id, String linea, String lat, String lon, String sentido){
        this.id = id;
        this.linea = linea;
        this.lat = lat;
        this.lon = lon;
        this.sentido = sentido;
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
}
