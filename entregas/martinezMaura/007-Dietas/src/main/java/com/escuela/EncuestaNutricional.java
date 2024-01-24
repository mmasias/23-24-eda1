package com.escuela;

import java.util.TreeMap;

class EncuestaNutricional {
    String nombrePaciente;
    TreeMap<Integer, Dia> diasEncuestados;

    public EncuestaNutricional(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
        this.diasEncuestados = new TreeMap<>();
    }

    public void agregarDia(int numeroDia) {
        if (diasEncuestados.size() < 5) {
            Dia dia = new Dia(numeroDia);
            diasEncuestados.put(numeroDia, dia);
        } else {
            System.out.println("No se pueden agregar más de 5 días a la encuesta.");
        }
    }

    public void registrarAlimento(int numeroDia, String tipoIngesta, String nombreAlimento) {
        Dia dia = diasEncuestados.get(numeroDia);
        if (dia != null) {
            dia.registrarAlimento(tipoIngesta, nombreAlimento);
        } else {
            System.out.println("No se encontró el día especificado.");
        }
    }

    public void mostrarEncuesta() {
        if (diasEncuestados.isEmpty()) {
            System.out.println("No hay datos de encuesta para mostrar.");
            return;
        }

        System.out.println("Encuesta Nutricional para " + nombrePaciente + ":");

        for (Dia dia : diasEncuestados.values()) {
            dia.mostrarDia();
        }
    }
}
