package com.escuela;

import java.util.TreeMap;

class Dia {
    int numeroDia;
    TreeMap<String, Ingesta> ingestas;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new TreeMap<>();
    }

    public void registrarAlimento(String tipoIngesta, String nombreAlimento) {
        Ingesta ingesta = ingestas.get(tipoIngesta);
        if (ingesta != null) {
            ingesta.agregarAlimento(nombreAlimento);
        } else {
            System.out.println("No se encontró el tipo de ingesta especificado.");
        }
    }

    public void mostrarDia() {
        System.out.println("\nDía " + numeroDia + ":");

        if (ingestas.isEmpty()) {
            System.out.println("   Sin datos de ingesta para mostrar.");
        } else {
            for (Ingesta ingesta : ingestas.values()) {
                System.out.println("  " + ingesta.tipo + ":");
                if (ingesta.alimentos.isEmpty()) {
                    System.out.println("      Sin alimentos registrados.");
                } else {
                    for (Alimento alimento : ingesta.alimentos.values()) {
                        System.out.println("      " + alimento.nombre);
                    }
                }
            }
        }
    }
}
