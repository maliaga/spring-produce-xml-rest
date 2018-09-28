package com.marioaliaga.demo.services.impl;

import com.marioaliaga.demo.dominio.Empresa;
import com.marioaliaga.demo.dominio.Persona;
import com.marioaliaga.demo.services.XMLService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class XMLServiceImpl implements XMLService {
    @Override
    public List<String> findAll() {
        return Arrays.asList("UNO", "DOS", "TRES");
    }

    @Override
    public List<Persona> findAllPersonas() {
        List<Persona> personas = new ArrayList<>(0);
        Empresa empresa = new Empresa("ERGON", "TI");
        Persona persona = new Persona("Mario", "Aliaga", empresa);
        personas.add(persona);
        return personas;
    }
}
