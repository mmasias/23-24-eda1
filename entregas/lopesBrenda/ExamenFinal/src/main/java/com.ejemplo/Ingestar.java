import java.util.ArrayList;
import java.util.List;

class Ingestar {

  String tipo;
  static List<AlimentoNodo> alimentos;

  public Ingestar(String tipo) {
    this.tipo = tipo;
    this.alimentos = new ArrayList<>();
  }

  public static void agregarAlimento(String nombre) {
    AlimentoNodo nuevoAlimento = new AlimentoNodo(nombre);
    alimentos.add(nuevoAlimento);
  }

  public static void mostrarAlimentos() {
    if (alimentos.isEmpty()) {
      System.out.println("      Sin alimentos registrados.");
    } else {
      for (AlimentoNodo alimentoNodo : alimentos) {
        mostrarAlimentosRecursivo(alimentoNodo, 2);
      }
    }
  }

  private static void mostrarAlimentosRecursivo(AlimentoNodo nodo, int nivel) {
    for (int i = 0; i < nivel; i++) {
      System.out.print(" ");
    }
    System.out.println(nodo.alimento.nombre);

    for (AlimentoNodo hijo : nodo.hijos) {
      mostrarAlimentosRecursivo(hijo, nivel + 2);
    }
  }
}

class AlimentoNodo {

  Alimento alimento;
  List<AlimentoNodo> hijos;

  public AlimentoNodo(String nombre) {
    this.alimento = new Alimento(nombre);
    this.hijos = new ArrayList<>();
  }

  public void agregarHijo(AlimentoNodo hijo) {
    this.hijos.add(hijo);
  }
}

