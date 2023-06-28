package com.example.proyectoandroidugel.models;

public class Noticia {
    private String titulo;
    private String portada;
    private String imagen;
    private String url;

    public Noticia(){}

    public Noticia(String titulo, String portada,String imagen,String url) {
        this.titulo = titulo;
        this.portada = portada;
        this.imagen = imagen;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
