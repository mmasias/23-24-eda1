package com.examen;

import java.util.ArrayList;
import java.util.List;

class EncuestaNutricional {

  String nombrePaciente;
  List<Dia> diasEncuestados;

  public EncuestaNutricional(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
    this.diasEncuestados = new ArrayList<>();
  }

  public void agregarDia(int numeroDia) {
    if (diasEncuestados.size() < 5) {
      Dia dia = new Dia(numeroDia);
      diasEncuestados.add(dia);
    } else {
      System.out.println("No se pueden agregar más de 5 días a la encuesta.");
    }
  }
