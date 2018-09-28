package com.marioaliaga.demo.dominio;

import javax.xml.bind.annotation.*;


public class Empresa {

    @XmlElement(name = "nombre")
    private String nombre;

    @XmlAttribute
    private String apellido;

    public Empresa() {
    }

    public Empresa(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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
}
