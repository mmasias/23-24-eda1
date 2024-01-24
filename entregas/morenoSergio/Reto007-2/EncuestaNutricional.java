import java.time.LocalDate;
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
    Dia dia = new Dia(numeroDia);
    diasEncuestados.add(dia);
  }

  public void registrarAlimento(int numeroDia, String tipoIngesta, String nombreAlimento) {
    for (Dia dia : diasEncuestados) {
      if (dia.numeroDia == numeroDia) {
        for (Ingesta ingesta : dia.ingestas) {
          if (ingesta.tipo.equals(tipoIngesta)) {
            ingesta.agregarAlimento(nombreAlimento);
            return;
          }
        }
        // Ingesta no encontrada, se agrega a la lista.
        Ingesta ingesta = dia.agregarIngesta(tipoIngesta);
        ingesta.agregarAlimento(nombreAlimento);
        return;
      }
    }
    System.out.println("No se encontró el día o tipo de ingesta especificado.");
  }

  public void mostrarEncuesta(LocalDate fechaAlta, LocalDate fechaEncuesta) {
    if (diasEncuestados.isEmpty()) {
      System.out.println("No hay datos de encuesta para mostrar.");
      return;
    }

    System.out.println("\n" + "Paciente: " + nombrePaciente);
    ImprimirFechas.imprimirFechas(fechaAlta, fechaEncuesta);
    System.out.println("  " + "Encuesta");

    for (Dia dia : diasEncuestados) {
      System.out.println("    " + "Día " + dia.numeroDia + ":");

      if (dia.ingestas.isEmpty()) {
        System.out.println("      " + "Sin datos de ingesta para mostrar.");
      } else {
        for (Ingesta ingesta : dia.ingestas) {
          System.out.println("      " + ingesta.tipo + ":");
          if (ingesta.alimentos.isEmpty()) {
            System.out.println("            " + "Sin alimentos registrados.");
          } else {
            for (Alimento alimento : ingesta.alimentos) {
              System.out.println("            " + alimento.nombre);
            }
          }
        }
      }
    }
  }
}
