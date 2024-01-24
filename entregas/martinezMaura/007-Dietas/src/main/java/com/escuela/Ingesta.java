package com.escuela;

import java.util.Map;
import java.util.TreeMap;

class Ingesta {
    String tipo;
    Map<String, Alimento> alimentos;

    public Ingesta(String tipo) {
        this.tipo = tipo;
        this.alimentos = new TreeMap<>();
    }

    public void agregarAlimento(String nombre) {
        Alimento alimento = new Alimento(nombre);
        alimentos.put(nombre, alimento);
    }
}

