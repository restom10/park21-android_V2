package com.example.park21.models;

public class Parqueadero {

    private String title;
    private String imageUrl;
    private String nombre;
    private String numeroParqueaderos;
    private String direccion;
    private String lat;
    private String longitud;

    public Parqueadero(String imageUrl, String title, String nombre, String numeroParqueaderos, String direccion, String lat, String longitud) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.nombre = nombre;
        this.numeroParqueaderos = numeroParqueaderos;
        this.direccion = direccion;
        this.longitud = longitud;
        this.lat = lat;
    }

    public Parqueadero() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroParqueaderos() {
        return numeroParqueaderos;
    }

    public String getDireccion() {
        return direccion;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroParqueaderos(String numeroParqueaderos) {
        this.numeroParqueaderos = numeroParqueaderos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
