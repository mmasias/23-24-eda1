import java.util.*;

class Alimento {
  String nombre;

  public Alimento(String nombre) {
    this.nombre = nombre;
  }
}

class Ingesta {
  List<Alimento> alimentos;

  public Ingesta() {
    this.alimentos = new ArrayList<>();
  }

  public void agregarAlimento(String nombre) {
    this.alimentos.add(new Alimento(nombre));
  }
}

class Dia {
  Map<String, Ingesta> ingestas;

  public Dia() {
    this.ingestas = new HashMap<>();
  }

  public void agregarIngesta(String tipo, Ingesta ingesta) {
    this.ingestas.put(tipo, ingesta);
  }
}

class Encuesta {
  Map<Integer, Dia> dias;

  public Encuesta() {
    this.dias = new HashMap<>();
  }

  public void agregarDia(int numero, Dia dia) {
    this.dias.put(numero, dia);
  }
}

class Paciente {
  String nombre;
  Map<String, Encuesta> encuestas;

  public Paciente(String nombre) {
    this.nombre = nombre;
    this.encuestas = new HashMap<>();
  }

  public void agregarEncuesta(String fecha, Encuesta encuesta) {
    this.encuestas.put(fecha, encuesta);
  }
}

public class SistemaEncuestas {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Crear paciente
    Paciente paciente = new Paciente("Jose Manuel R.");

    // Interacción con el usuario
    while (true) {
      System.out.println("Seleccione día (1-5) o -1 para salir:");
      int numeroDia = scanner.nextInt();
      if (numeroDia == -1) {
        break;
      }

      Dia dia = new Dia();

      // Interacción para cada ingesta
      for (int i = 1; i <= 5; i++) {
        Ingesta ingesta = new Ingesta();

        System.out.println("Seleccione ingesta (1-Desayuno, 2-Media mañana, 3-Almuerzo, 4-Merienda, 5-Cena, -1-Menú anterior):");
        int tipoIngesta = scanner.nextInt();
        if (tipoIngesta == -1) {
          break;
        }

        System.out.println("Ingrese alimentos para la ingesta del día " + numeroDia + " (" + tipoIngesta + "):");
        while (true) {
          System.out.println("Ingrese un alimento (-1 para terminar / -2 para listar alimentos ingresados):");
          String nombreAlimento = scanner.next();

          if (nombreAlimento.equals("-1")) {
            break;
          } else if (nombreAlimento.equals("-2")) {
            // Listar alimentos ingresados
            for (Alimento alimento : ingesta.alimentos) {
              System.out.println(alimento.nombre);
            }
          } else {
            ingesta.agregarAlimento(nombreAlimento);
          }
        }

        dia.agregarIngesta(Integer.toString(tipoIngesta), ingesta);
      }

      // Agregar el día a la encuesta
      Encuesta encuesta = paciente.encuestas.getOrDefault(Integer.toString(numeroDia), new Encuesta());
      encuesta.agregarDia(numeroDia, dia);
      paciente.agregarEncuesta(Integer.toString(numeroDia), encuesta);
    }

    // Mostrar datos almacenados
    System.out.println(paciente.nombre);
    for (Map.Entry<String, Encuesta> entry : paciente.encuestas.entrySet()) {
      System.out.println("    Encuesta");
      System.out.println("        Dia " + entry.getKey());

      Encuesta encuesta = entry.getValue();

      for (Map.Entry<Integer, Dia> diaEntry : encuesta.dias.entrySet()) {
        int numeroDia = diaEntry.getKey();
        Dia dia = diaEntry.getValue();

        System.out.println("            Dia " + numeroDia + ":");

        for (Map.Entry<String, Ingesta> ingestaEntry : dia.ingestas.entrySet()) {
          String tipoIngesta = ingestaEntry.getKey();
          Ingesta ingesta = ingestaEntry.getValue();

          System.out.println("                " + tipoIngesta + ":");

          for (Alimento alimento : ingesta.alimentos) {
            System.out.println("                    " + alimento.nombre);
          }
        }
      }
    }
  }
}
