package com.marioaliaga.demo.services;

import com.marioaliaga.demo.dominio.Persona;

import java.util.List;

public interface XMLService {
    public List<String> findAll();
    public List<Persona> findAllPersonas();
}
