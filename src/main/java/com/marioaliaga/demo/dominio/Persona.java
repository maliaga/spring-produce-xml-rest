package com.marioaliaga.demo.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persona-trabajador")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    private String nombre;
    private String apellido;
    private Empresa empresa;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Empresa empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
