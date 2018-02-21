package com.example.sergio.sergioromerosegundo;

import java.io.Serializable;

/**
 * Created by Sergio on 21/02/2018.
 */

public class Paises implements Serializable{

    private String nombreIn;
    private String nombreEs;
    private String clave;
    private String capital;
    private String continente;
    private String poblacion;
    private String latitud;
    private String longitud;
    private String paisFront;

    public Paises(String nombreIn/*, String nombreEs, String clave, String capital, String continente, String poblacion, String latitud, String longitud, String paisFront*/) {
        this.nombreIn = nombreIn;
        /*this.nombreEs = nombreEs;
        this.clave = clave;
        this.capital = capital;
        this.continente = continente;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paisFront = paisFront;*/
    }

    public String getNombreIn() {
        return nombreIn;
    }

    public void setNombreIn(String nombreIn) {
        this.nombreIn = nombreIn;
    }

    public String getNombreEs() {
        return nombreEs;
    }

    public void setNombreEs(String nombreEs) {
        this.nombreEs = nombreEs;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPaisFront() {
        return paisFront;
    }

    public void setPaisFront(String paisFront) {
        this.paisFront = paisFront;
    }
}
