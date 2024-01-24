package Arboles.model;

public class Paciente {
  public String nombre;
  public Encuesta encuestas;

  public Paciente(String nombre) {
      this.nombre = nombre;
      this.encuestas = new Encuesta();
  }

  public void agregarEncuesta(Dia dia) {
      this.encuestas.agregarDia(dia);
  }
}


