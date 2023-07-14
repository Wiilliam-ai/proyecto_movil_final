package com.example.proyectoandroidugel.models;

public class Usuario {
    private String token;
    private String status;
    private String rol;

    public Usuario(){}
    public Usuario(String token, String status, String rol) {
        this.token = token;
        this.status = status;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
