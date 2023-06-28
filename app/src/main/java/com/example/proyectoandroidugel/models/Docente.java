package com.example.proyectoandroidugel.models;

public class Docente {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String fechaNacimieto;
    private String dni;
    private String cargo;
    private String codigoModular;
    private String codicion;
    private String telefono;
    private String especializacion;
    private String foto;

    public Docente(){}


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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimieto() {
        return fechaNacimieto;
    }

    public void setFechaNacimieto(String fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodigoModular() {
        return codigoModular;
    }

    public void setCodigoModular(String codigoModular) {
        this.codigoModular = codigoModular;
    }

    public String getCodicion() {
        return codicion;
    }

    public void setCodicion(String codicion) {
        this.codicion = codicion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
