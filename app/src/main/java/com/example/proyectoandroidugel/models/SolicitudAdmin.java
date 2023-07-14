package com.example.proyectoandroidugel.models;

public class SolicitudAdmin {
    private String solicitud;
    private String fecha;
    private String nombre;
    private String dni;
    private String estado;

    public SolicitudAdmin(){}

    public SolicitudAdmin(String solicitud, String fecha, String nombre, String dni, String estado) {
        this.solicitud = solicitud;
        this.fecha = fecha;
        this.nombre = nombre;
        this.dni = dni;
        this.estado = estado;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
