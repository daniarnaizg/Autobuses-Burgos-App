package com.burbus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Linea implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("nombreIda")
    private String nombreIda;
    @SerializedName("nombreVuelta")
    private String nombreVuelta;

    public Linea(String id, String nombre, String nombreIda, String nombreVuelta) {
        this.id = id;
        this.nombre = nombre;
        this.nombreIda = nombreIda;
        this.nombreVuelta = nombreVuelta;
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

    public String getNombreIda() {
        return nombreIda;
    }

    public void setNombreIda(String nombreIda) {
        this.nombreIda = nombreIda;
    }

    public String getNombreVuelta() {
        return nombreVuelta;
    }

    public void setNombreVuelta(String nombreVuelta) {
        this.nombreVuelta = nombreVuelta;
    }

    public String getHorarioLaboralIda(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 06:10, 06:45 y de 07:15 a 23:20 cada 7 minutos";
                break;
            case "2":
                horario = "\u2022 07:15 y de 07:30 a 22:30 cada 30 minutos\n\u2022 23:00 sólo hasta el centro";
                break;
            case "3":
                horario = "\u2022 De 07:40 a 22:20 cada 80 minutos\n\u2022 Desde el Barrio Villalonquéjar a las 08:55";
                break;
            case "4":
                horario = "\u2022 De 07:15 a 22:15 cada 30 minutos\n\u2022 22:45 hasta Plaza España";
                break;
            case "5":
                horario = "\u2022 08:20 a 21:40 cada 80 minutos\n\u2022 23:00 sólo hasta el centro";
                break;
            case "6":
                horario = "\u2022 De 07:20 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 De 07:40 a 22:20 cada 80 minutos";
                break;
            case "8":
                horario = "\u2022 06:30 y de 07:30 a 21:30 cada 30 minutos\n\u2022 Miércoles y viernes hasta Barrio de Cótar: 09:30 y 12:30";
                break;
            case "9":
                horario = "\u2022 Hasta Cortes: 08:00, 09:00, 10:00, 12:00, 19:00, 20:00, 21:00 y 22:00\n\u2022 Hasta Residencia del Imserso: 13:00 y 19:00\n\u2022 Hasta San Pedro Cardeña 128: 13:00, 14:00 y 15:00";
                break;
            case "10":
                horario = "\u2022 De 07:45 a 22:45 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 08:00 a 23:00 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 De 08:20 a 23:00 cada 80 minutos\n\u2022 Desde Villalonquéjar: 13:35. Hasta el centro a las 23:00";
                break;
            case "13":
                horario = "\u2022 07:20\n\u2022 07:40\n\u2022 De 08:00 a 22:00 cada 30 minutos";
                break;
            case "14":
                horario = "\u2022 De 07:00 a 13:40 cada 40 minutos\n\u2022 14:40 y 15:20\n\u2022 De 16:00 a 20:40 cada 40 minutos\n\u2022 21:40 y 22:20";
                break;
            case "15":
                horario = "\u2022 De 08:30 a 12:30 cada 30 minutos\n\u2022 De 16:30 a 20:30 cada 30 minutos ";
                break;
            case "16":
                horario = "\u2022 De 07:20 a 10:00 cada 40 minutos\n\u2022 11:20 y 12:20\n\u2022 De 13:00 a 15:00 cada 40 minutos\n\u2022 De 17:20 a 20:00 cada 40 minutos";
                break;
            case "17":
                horario = "\u2022 Sin servicio";
                break;
            case "18":
                horario = "\u2022 07:00 y de 07:40 a 09:40 cada 20 minutos\n\u2022 10:20, 11:00 y 11:40\n\u2022 De 12:20 a 15:00 cada 20 minutos\n\u2022 15:40 y 16:20\n\u2022 De 17:00 a 20:20 cada 20 minutos — 21:00, 21:40 y 22:20";
                break;
            case "19":
                horario = "\u2022 De 07:30 a 22:30 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 07:10, 07:50, 8:50, 11:00, 13:15, 14:30, 15:30, 16:50, 17:40 y 18:20";
                break;
            case "22":
                horario = "\u2022 De 07:20 a 22:40 cada 40 minutos";
                break;
            case "25":
                horario = "\u2022 De 07:45 a 22:15 cada 30 minutos\n\u2022 Desde Conde Lucanor hasta el barrio de San Cristobal";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:00 a 14:00 cada 60 minutos\n\u2022 16:30\n\u2022 De 17:00 a 21:00 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:30, 12:30, 16:15 y 19:15";
                break;
            case "38":
                horario = "\u2022 07:15 por el HUBU\n\u2022 De 08:20 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro 06:45 y 23:10\n\u2022 Desde el barrio de Villalonquéjar 07:55, 11:55, 14:35, 15:15, 17:15, 18:35, 21:15, 22:35 y 23:50";
                break;
            case "39":
                horario = "\u2022 De 07:20 a 22:40 cada 40 minutos";
                break;
            case "43":
                horario = "\u2022 De 07:45 a 22:45 cada 60 minutos";
                break;
            case "44":
                horario = "\u2022 Desde Gamonal por la barriada Yagüe: 06.30\n\u2022 De 07:30 a 10:30 cada 60 minutos\n\u2022 De 13:30 a 15:30 cada 60 minutos\n\u2022 De 17:30 a 19:30 cada 60 minutos\n\u2022 Hasta el barrio de Villalonquéjar: 09:30, 14:30 y 19:30";
                break;
            case "45":
                horario = "\u2022 De 07:15 a 22:45 cada 30 minutos";
                break;
            case "80":
                horario = "\u2022 07:20, 07:50, 08:20, 08:50, 09:20, 14:50, 15:20 y 15:50";
                break;
            case "81":
                horario = "\u2022 Sólo laborables lectivos\n\u2022 07:30, 08:00 y 08:30";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Sin servicio";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioLaboralVuelta(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 06:30 y de 07:00 a 23:15 cada 7 minutos";
                break;
            case "2":
                horario = "\u2022 07:15 desde Plaza España\n\u2022 De 07:30 a 22:30 cada 30 minutos\n\u2022  Sólo hasta el centro: 23:00";
                break;
            case "3":
                horario = "\u2022 De 08:20 a 21:40 cada 80 minutos\n\u2022 Desde la Plaza España a la barriada Yagüe: 07:20\n\u2022 Sólo hasta el centro: 23:00\n\u2022 Hasta el barrio de Villalonquéjar: 08:20";
                break;
            case "4":
                horario = "\u2022 De 07:15 a 22:15 cada 30 minutos\n\u2022 Hasta Plaza España: 22:45\n\u2022 Hasta el barrio de Castañares: 16:15, 21:15 y 22:15";
                break;
            case "5":
                horario = "\u2022 07:40 a 22:20 cada 80 minutos\n\u2022 Desde la Plaza España: 06:45";
                break;
            case "6":
                horario = "\u2022 De 07:20 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 Desde la C/ Marqués de Berlanga, por el Hospital Universitario: 07.00\n\u2022 De 8:20 a 21:40 cada 80 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "8":
                horario = "\u2022 07:00 a 21:00 cada 30 minutos\n\u2022 21:50\n\u2022 Hasta C/Vitoria 252: 23:00\n\u2022 Miércoles y viernes desde el Barrio de Cótar: 10:00 y 13:00";
                break;
            case "9":
                horario = "\u2022 Desde Cortes: 08:25, 09:25, 10:25, 12:25, 19:25, 20:25, 21:25 y 22:25\n\u2022 Desde Residencia del Imserso: 10:25 y 15:30\n\u2022 Desde San Pedro Cardeña 128: 13:30, 14:30 y 15:30";
                break;
            case "10":
                horario = "\u2022 De 07:30 a 22:30 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 07:30 a 22:30 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 De 07:40 a 22:20 cada 80 minutos\n\u2022 Hasta el barrio de Villalonquéjar: 13:00";
                break;
            case "13":
                horario = "\u2022 07:40\n\u2022 De 08:00 a 22:30 cada 30 minutos";
                break;
            case "14":
                horario = "\u2022 De 07:20 a 14:00 cada 40 minutos\n\u2022 De 15:00 a 21:00 cada 40 minutos\n\u2022 22:40 y 22:40\n\u2022 Hasta el Hospital Provincial: 8:00, 15:00 y 22:00";
                break;
            case "15":
                horario = "\u2022 Sin servicio";
                break;
            case "16":
                horario = "\u2022 De 07:40 a 10:20 cada 40 minutos\n\u2022 11:40 y 12:40\n\u2022 De 13:20 a 15:20 cada 40 minutos\n\u2022 De 17:40 a 20:20 cada 40 minutos";
                break;
            case "17":
                horario = "\u2022 Sin servicio";
                break;
            case "18":
                horario = "\u2022 07:20 a 10:00 cada 20 minutos\n\u2022 De 10:40 a 13:00 cada 40 minutos\n\u2022 De 13:20 a 15:20 cada 20 minutos\n\u2022 De 16:00 a 17:20 cada 40 minutos\n\u2022 De 17:40 a 20:00 cada 20 minutos\n\u2022 De 20:40 a 22:40 cada 40 minutos";
                break;
            case "19":
                horario = "\u2022 De 07:00 a 22:00 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 07:30, 08:10, 9:10, 11:20, 13:35, 14:50, 15:15, 15:50, 17:10, 18:00 y 18:40";
                break;
            case "22":
                horario = "\u2022 De 07:20 a 22:00 cada 40 minutos";
                break;
            case "25":
                horario = "\u2022 De 07:30 a 22:30 cada 30 minutos";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:15 a 14:15 cada 60 minutos\n\u2022 16:45\n\u2022 De 17:15 a 21:15 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:45, 12:45, 16:30 y 19:30";
                break;
            case "38":
                horario = "\u2022 Por el HUBU: 08:00\n\u2022 De 07:20 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro: 23:10\n\u2022 Desde la Plaza España: 06:30 y 07:00\n\u2022 Hasta el barrio de Villalonquéjar 07:20, 11:20, 14:00, 14:40, 16:40 (excepto sábados), 18:00, 20:40, 22:00 y 23:30";
                break;
            case "39":
                horario = "\u2022 De la plaza de España al barrio de El Pilar: 07:00\n\u2022 De 07:20 a 22:00 cada 40 minutos\n\u2022 Sólo hasta C/Vitoria 7: 22:40";
                break;
            case "43":
                horario = "\u2022 De 07:15 a 22:15 cada 60 minutos";
                break;
            case "44":
                horario = "\u2022 De 08:00 a 11:00 cada 60 minutos\n\u2022 De 14:00 a 16:00 cada 60 minutos\n\u2022 De 18:00 a 20:00 cada 60 minutos\n\u2022 Desde el barrio de Villalonquéjar: 10:00, 15:00 y 20:00";
                break;
            case "45":
                horario = "\u2022 Desde Plaza España: 07:30\n\u2022 De 07:45 a 22:15 cada 30 minutos\n\u2022 Hasta la avenida del Arlanzón: 22:45";
                break;
            case "80":
                horario = "\u2022 13:05, 14:05, 14:35, 15:00, 20:05, 20:05 y 21:40";
                break;
            case "81":
                horario = "\u2022 Sin servicio";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Sin servicio";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioSabadosIda(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 06:10, 06:45 y de 07:15 a 23:20 cada 7 minutos";
                break;
            case "2":
                horario = "\u2022 07:15 y de 07:30 a 22:30 cada 30 minutos\n\u2022 23:00 sólo hasta el centro";
                break;
            case "3":
                horario = "\u2022 Sin servicio";
                break;
            case "4":
                horario = "\u2022 De 07:15 a 22:15 cada 30 minutos\n\u2022 22:45 hasta Plaza España\n\u2022 Desde el barrio de Castañares: 07:40, 08:10, 09:40, 10:10, 12:40, 17:40, 19:40 y 22:40";
                break;
            case "5":
                horario = "\u2022 Por el HUBU: 07:00\n\u2022 08:20 a 21:40 cada 80 minutos\n\u2022 23:00 sólo hasta el centro";
                break;
            case "6":
                horario = "\u2022 De 07:20 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 De 07:40 a 22:20 cada 80 minutos";
                break;
            case "8":
                horario = "\u2022 De 06:30 a 21:30 cada 60 minutos\n\u2022 22:45 (hasta Villafría)";
                break;
            case "9":
                horario = "\u2022 Hasta Cortes: 08:00, 09:00, 10:00, 12:00, 13:00, 15:00, 19:00, 20:00, 21:00 y 22:00\n\u2022 Hasta Residencia del Imserso: 13:00 y 19:00\n\u2022 Hasta San Pedro Cardeña 128: 14:00";
                break;
            case "10":
                horario = "\u2022 De 07:45 a 22:45 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 08:00 a 23:00 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 Sin servicio";
                break;
            case "13":
                horario = "\u2022 07:20\n\u2022 De 10:30 a 13:30 cada 60 minutos\n\u2022 De 16:30 a 18:30 cada 60 minutos";
                break;
            case "14":
                horario = "\u2022 07:15\n\u2022 De 10:00 a 14:00 cada 60 minutos\n\u2022 De 18:00 a 21:00 cada 60 minutos\n\u2022 23:00";
                break;
            case "15":
                horario = "\u2022 De 08:30 a 12:30 cada 30 minutos\n\u2022 De 16:30 a 20:30 cada 30 minutos ";
                break;
            case "16":
                horario = "\u2022 14:30";
                break;
            case "17":
                horario = "\u2022 Sin servicio";
                break;
            case "18":
                horario = "\u2022 De 07:20 a 22:40 cada 40 minutos";
                break;
            case "19":
                horario = "\u2022 De 07:30 a 22:30 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 11:00 y 17:00";
                break;
            case "22":
                horario = "\u2022 De 09:20 a 22:40 cada 80 minutos";
                break;
            case "25":
                horario = "\u2022 De 08:00 a 22:00 cada 40 minutos\n\u2022 22:30";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:00 a 14:00 cada 60 minutos\n\u2022 16:30\n\u2022 De 17:00 a 21:00 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:30, 12:30, 16:15 y 19:15";
                break;
            case "38":
                horario = "\u2022 07:15 por el HUBU\n\u2022 De 08:20 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro 06:45 y 23:10\n\u2022 Desde el barrio de Villalonquéjar 07:55, 11:55, 14:35, 15:15, 17:15, 18:35, 21:15, 22:35 y 23:50";
                break;
            case "39":
                horario = "\u2022 Sin servicio";
                break;
            case "43":
                horario = "\u2022 Sin servicio";
                break;
            case "44":
                horario = "\u2022 Sin servicio";
                break;
            case "45":
                horario = "\u2022 Sin servicio";
                break;
            case "80":
                horario = "\u2022 Sin servicio";
                break;
            case "81":
                horario = "\u2022 Sin servicio";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Sin servicio";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioSabadosVuelta(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 De 07:00 a 23:15 cada 7 minutos";
                break;
            case "2":
                horario = "\u2022 07:15 desde Plaza España\n\u2022 De 07:30 a 22:30 cada 30 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "3":
                horario = "\u2022 De 08:20 a 21:40 cada 80 minutos\n\u2022 Desde la Plaza España a la barriada Yagüe: 07:20\n\u2022 Sólo hasta el centro: 23:00\n\u2022 Hasta el barrio de Villalonquéjar: 08:20";
                break;
            case "4":
                horario = "\u2022 De 07:15 a 22:15 cada 30 minutos\n\u2022 Hasta Plaza España: 22:45\n\u2022 Hasta el barrio de Castañares: 07:15, 07:45, 09:15, 09:45, 12:15, 17:15, 19:15, 22:15";
                break;
            case "5":
                horario = "\u2022 07:40 a 22:20 cada 80 minutos\n\u2022 Desde la Plaza España: 06:45";
                break;
            case "6":
                horario = "\u2022 De 07:20 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 Desde la C/ Marqués de Berlanga, por el Hospital Universitario: 07.00\n\u2022 De 8:20 a 21:40 cada 80 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "8":
                horario = "\u2022 07:00 a 21:00 cada 60 minutos\n\u2022 21:50\n\u2022 Hasta C/Vitoria 252: 23:00";
                break;
            case "9":
                horario = "\u2022 Desde Cortes: 08:25, 09:25, 10:25, 12:25, 13:25, 15:25, 19:25, 20:25, 21:25 y 22:25\n\u2022 Desde Residencia del Imserso: 10:25 y 15:25\n\u2022 Desde San Pedro Cardeña 128: 14:30";
                break;
            case "10":
                horario = "\u2022 De 07:30 a 22:30 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 07:30 a 22:30 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 Sin servicio";
                break;
            case "13":
                horario = "\u2022 08:00\n\u2022 De 10:00 a 14:00 cada 60 minutos\n\u2022 De 17:00 a 19:00 cada 60 minutos";
                break;
            case "14":
                horario = "\u2022 7:30, 10:20, 11:20, 12:15, 13:20, 14:15\n\u2022 De 18:20 a 21:20 cada 60 minutos\n\u2022 23:10";
                break;
            case "15":
                horario = "\u2022 Sin servicio";
                break;
            case "16":
                horario = "\u2022 14:50";
                break;
            case "17":
                horario = "\u2022 Sin servicio";
                break;
            case "18":
                horario = "\u2022 07:40 a 23:00 cada 40 minutos";
                break;
            case "19":
                horario = "\u2022 De 07:00 a 22:00 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 11:20 y 17:20";
                break;
            case "22":
                horario = "\u2022 De 10:00 a 22:00 cada 80 minutos";
                break;
            case "25":
                horario = "\u2022 De 08:00 a 22:00 cada 40 minutos";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:15 a 14:15 cada 60 minutos\n\u2022 16:45\n\u2022 De 17:15 a 21:15 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:45, 12:45, 16:30 y 19:30";
                break;
            case "38":
                horario = "\u2022 Por el HUBU: 08:00\n\u2022 De 07:20 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro: 23:10\n\u2022 Desde la Plaza España: 06:30 y 07:00\n\u2022 Hasta el barrio de Villalonquéjar 07:20, 11:20, 14:00, 14:40, 18:00, 20:40, 22:00 y 23:30";
                break;
            case "39":
                horario = "\u2022 Sin servicio";
                break;
            case "43":
                horario = "\u2022 Sin servicio";
                break;
            case "44":
                horario = "\u2022 Sin servicio";
                break;
            case "45":
                horario = "\u2022 Sin servicio";
                break;
            case "80":
                horario = "\u2022 Sin servicio";
                break;
            case "81":
                horario = "\u2022 Sin servicio";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Sin servicio";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioDomingosIda(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 De 08:14 a 11:04 cada 14 minutos\n\u2022 De 11:04 a 23:20 cada 8 minutos";
                break;
            case "2":
                horario = "\u2022 Hasta los soportales de Antón: 08:00 y 08:30\n\u2022 Desde Plaza España a la carretera de Arcos: 08:45\n\u2022 De 09:00 a 22:30 cada 30 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "3":
                horario = "\u2022 Sin servicio";
                break;
            case "4":
                horario = "\u2022 07:15\n\u2022 Hasta Plaza España: 08:45, 09:45 (desde Castañares) y 10:45\n\u2022 De 11:15 a 22:45 cada 30 minutos\n\u2022 Desde los soportales de Antón a la barriada Illera: 11:00\n\u2022 Desde el barrio de Castañares: 12:40, 14:10, 17:40, 19:40 y 22:40";
                break;
            case "5":
                horario = "\u2022 De 11:20 a 21:40 cada 80 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "6":
                horario = "\u2022 08:40 y 09:20\n\u2022 De 10:00 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 Hasta el Hospital Universitario: 07:15\n\u2022 Sólo hasta el centro: 09:00 y 09:40\n\u2022 De 10:20 a 22:20 cada 80 minutos";
                break;
            case "8":
                horario = "\u2022 10:30, 12:30, 14:30, 17:30, 19:30 y 21:30\n\u2022 22:45 hasta Villafría";
                break;
            case "9":
                horario = "\u2022 Sin servicio";
                break;
            case "10":
                horario = "\u2022 De 09:45 a 22:45 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 10:00 a 23:00 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 Sin servicio";
                break;
            case "13":
                horario = "\u2022 07:20\n\u2022 De 10:30 a 13:30 cada 60 minutos\n\u2022 De 16:30 a 18:30 cada 60 minutos";
                break;
            case "14":
                horario = "\u2022 11:30, 13:30, 14:00, 17:00, 18:30, 20:30 y 22:30";
                break;
            case "15":
                horario = "\u2022 De 09:30 a 12:30 cada 30 minutos\n\u2022 De 16:30 a 20:30 cada 30 minutos";
                break;
            case "16":
                horario = "\u2022 Sin servicio";
                break;
            case "17":
                horario = "\u2022 10:00";
                break;
            case "18":
                horario = "\u2022  De 09:20 a 22:40 cada 40 minutos";
                break;
            case "19":
                horario = "\u2022 De 10:30 a 22:30 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 10:00, 17:00 y 22:00";
                break;
            case "22":
                horario = "\u2022 De 12:00 a 22:40 cada 80 minutos";
                break;
            case "25":
                horario = "\u2022 De 08:40 a 22:00 cada 40 minutos\n\u2022 22:30";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:00 a 14:00 cada 60 minutos\n\u2022 16:30\n\u2022 De 17:00 a 21:00 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:30, 12:30, 16:15 y 19:15";
                break;
            case "38":
                horario = "\u2022 Por el Hospital Universitario: 07:15\n\u2022 De 08:40 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro: 23:10\n\u2022 Desde el barrio de Villalonquéjar: 09:55, 11:55, 14:35, 16:15, 18:35, 21:15 y 22:35";
                break;
            case "39":
                horario = "\u2022 Sin servicio";
                break;
            case "43":
                horario = "\u2022 Sin servicio";
                break;
            case "44":
                horario = "\u2022 Sin servicio";
                break;
            case "45":
                horario = "\u2022 Sin servicio";
                break;
            case "80":
                horario = "\u2022 Sin servicio";
                break;
            case "81":
                horario = "\u2022 Sin servicio";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Desde los soportales de Antón: 09:30\n\u2022 Desde la calle Vitoria 255: 12:30\n\u2022 Por lo soportales de Antón: 12:45";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioDomingosVuelta(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 De 06:54 a 11:00 cada 14 minutos\n\u2022 De 11:00 a 23:15 cada 8 minutos";
                break;
            case "2":
                horario = "\u2022 07:15\n\u2022 Desde los soportales de Antón hasta el Hospital Universitario: 08:15 y 08:45\n\u2022 De 09:00 a 22:30 cada 30 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "3":
                horario = "\u2022 Sin servicio";
                break;
            case "4":
                horario = "\u2022 08:15\n\u2022 Desde Plaza España a La Ventilla: 08:30, 09:30 (hasta Castañares) 10:30 y 11:00\n\u2022 De 11:15 a 22:45 cada 30 minutos\n\u2022 Hasta el barrio de Castañares: 12:15, 13:45, 17:15, 19:15 y 22:15";
                break;
            case "5":
                horario = "\u2022 De 10:20 a 22:20 cada 80 minutos";
                break;
            case "6":
                horario = "\u2022 08:20 y 09:00\n\u2022 De 09:40 a 22:40 cada 20 minutos";
                break;
            case "7":
                horario = "\u2022 Desde el Hospital Universitario: 08:00\n\u2022 Desde Plaza España: 08:40, 09:20 y 10:00\n\u2022 De 11:00 a 21:40 cada 80 minutos\n\u2022 Sólo hasta el centro: 23:00";
                break;
            case "8":
                horario = "\u2022 11:00, 13:00, 15:00, 18:00, 20:00 y 22:00\n\u2022 Hasta la C/Vitoria 252: 23:00";
                break;
            case "9":
                horario = "\u2022 Sin servicio";
                break;
            case "10":
                horario = "\u2022 De 09:30 a 22:30 cada 30 minutos";
                break;
            case "11":
                horario = "\u2022 De 09:30 a 22:30 cada 60 minutos";
                break;
            case "12":
                horario = "\u2022 Sin servicio";
                break;
            case "13":
                horario = "\u2022 08:00\n\u2022 De 11:00 a 14:00 cada 60 minutos\n\u2022 De 17:00 a 19:00 cada 60 minutos";
                break;
            case "14":
                horario = "\u2022 11:45, 13:45, 14:15, 17:15, 18:45, 20:45 y 22:45";
                break;
            case "15":
                horario = "\u2022 Sin servicio";
                break;
            case "16":
                horario = "\u2022 Sin servicio";
                break;
            case "17":
                horario = "\u2022 10:50";
                break;
            case "18":
                horario = "\u2022  De 09:40 a 23:00 cada 40 minutos";
                break;
            case "19":
                horario = "\u2022 De 10:00 a 22:00 cada 60 minutos";
                break;
            case "21":
                horario = "\u2022 10:20, 17:20 y 22:20";
                break;
            case "22":
                horario = "\u2022 De 11:20 a 22:00 cada 80 minutos";
                break;
            case "25":
                horario = "\u2022 De 08:40 a 22:00 cada 40 minutos\n\u2022 22:30";
                break;
            case "26":
                horario = "\u2022 Del 29 de junio al 31 de agosto\n\u2022 De 11:15 a 14:15 cada 60 minutos\n\u2022 16:45\n\u2022 De 17:15 a 21:15 cada 60 minutos";
                break;
            case "27":
                horario = "\u2022 09:45, 12:45, 16:30 y 19:30";
                break;
            case "38":
                horario = "\u2022 Por el Hospital Universitario: 08:00\n\u2022 De 08:40 a 22:40 cada 40 minutos\n\u2022 Sólo hasta el centro: 23:10\n\u2022 Desde el barrio de Villalonquéjar: 09:20, 11:20, 14:00, 16:00, 18:00, 20:40 y 22:00";
                break;
            case "39":
                horario = "\u2022 Sin servicio";
                break;
            case "43":
                horario = "\u2022 Sin servicio";
                break;
            case "44":
                horario = "\u2022 Sin servicio";
                break;
            case "45":
                horario = "\u2022 Sin servicio";
                break;
            case "80":
                horario = "\u2022 Sin servicio";
                break;
            case "81":
                horario = "\u2022 Sin servicio";
                break;
            case "87":
                horario = "\u2022 Sin servicio";
                break;
            case "88":
                horario = "\u2022 Sin servicio";
                break;
            case "89":
                horario = "\u2022 Hasta la calle Vitoria 7: 11:00\n\u2022 Hasta la calle Vitoria 255: 14:00";
                break;
            case "91":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            case "92":
                horario = "\u2022 Servicio especial con motivo de la festividad de Todos Los Santos";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioNocturnosIda(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 Todos los días\n\u2022 23:30, 00:00 y 00:30";
                break;
            case "2":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "3":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "4":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "5":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "6":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "7":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "8":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "9":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "10":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "11":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "12":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "13":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "14":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "15":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "16":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "17":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "18":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "19":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "21":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "22":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "25":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "26":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "27":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "38":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "39":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "43":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "44":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "45":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "80":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "81":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "87":
                horario = "\u2022 Viernes y sábados durante el curso académico\n\u2022 00:00, 01:00 y 02:00";
                break;
            case "88":
                horario = "\u2022 Viernes y sábados durante el curso académico\n\u2022 00:00, 01:00, 01:30, 02:00, 02:30 \n\u2022 Hasta Villimar: 03:00";
                break;
            case "89":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "91":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "92":
                horario = "\u2022 Sin servicio nocturno";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getHorarioNocturnosVuelta(String id){
        String horario = "";
        switch(id){
            case "1":
                horario = "\u2022 Todos los días\n\u2022 23:45, 00:15 y 00:45";
                break;
            case "2":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "3":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "4":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "5":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "6":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "7":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "8":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "9":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "10":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "11":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "12":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "13":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "14":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "15":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "16":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "17":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "18":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "19":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "21":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "22":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "25":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "26":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "27":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "38":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "39":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "43":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "44":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "45":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "80":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "81":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "87":
                horario = "\u2022 Viernes y sábados durante el curso académico\n\u2022 00:30 y 01:30";
                break;
            case "88":
                horario = "\u2022 Viernes y sábados durante el curso académico\n\u2022 23:45, 00:15, 00:45, 01:15, 01:45, 02:15 y 02:45";
                break;
            case "89":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "91":
                horario = "\u2022 Sin servicio nocturno";
                break;
            case "92":
                horario = "\u2022 Sin servicio nocturno";
                break;
            default:
                horario = "\u2022 Información no disponible en este momento";
                break;
        }
        return horario;
    }

    public String getColor(String id) {
        String color = "";
        switch(id){
            case "1":
                color = "#B3E10021";
                break;
            case "2":
                color = "#B39F3E8A";
                break;
            case "3":
                color = "#B378B467";
                break;
            case "4":
                color = "#B3F4A963";
                break;
            case "5":
                color = "#B3FDCC00";
                break;
            case "6":
                color = "#B388C2E2";
                break;
            case "7":
                color = "#B35F4887";
                break;
            case "8":
                color = "#B3005A29";
                break;
            case "9":
                color = "#B35B303E";
                break;
            case "10":
                color = "#B3BE0243";
                break;
            case "11":
                color = "#B3F1DA00";
                break;
            case "12":
                color = "#B3A4131F";
                break;
            case "13":
                color = "#B34AC0E7";
                break;
            case "14":
                color = "#B3DDB82E";
                break;
            case "15":
                color = "#B3006FB0";
                break;
            case "16":
                color = "#B3B0BC93";
                break;
            case "17":
                color = "#B3EF9FBE";
                break;
            case "18":
                color = "#B3A1A012";
                break;
            case "19":
                color = "#B3BA0068";
                break;
            case "21":
                color = "#B36EC3C9";
                break;
            case "22":
                color = "#B3CA4E19";
                break;
            case "25":
                color = "#B320296D";
                break;
            case "26":
                color = "#B3AE7DAD";
                break;
            case "27":
                color = "#B3659726";
                break;
            case "38":
                color = "#B3499E2B";
                break;
            case "39":
                color = "#B3DC0078";
                break;
            case "43":
                color = "#B3009799";
                break;
            case "44":
                color = "#B317171D";
                break;
            case "45":
                color = "#B3C9D000";
                break;
            case "80":
                color = "#B3FFEB00";
                break;
            case "81":
                color = "#B3D8B95E";
                break;
            case "87":
                color = "#B3C9D000";
                break;
            case "88":
                color = "#B3E10021";
                break;
            case "89":
                color = "#B35E82BF";
                break;
            case "91":
                color = "#B345606D";
                break;
            case "92":
                color = "#B345606D";
                break;
            default:
                color = "#B345606D";
                break;
        }
        return color;

    }
}
