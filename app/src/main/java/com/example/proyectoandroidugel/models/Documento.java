package com.example.proyectoandroidugel.models;

public class Documento {
    private int id;
    private String nombre;
    private String archivo;
    private String fecha;

    public Documento(){}

    public Documento(int id, String nombre, String archivo, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.archivo = archivo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
