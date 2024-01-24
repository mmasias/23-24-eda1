import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alimento {
    private List<Alimento> alimentos;

    public Alimento() {
        alimentos = new ArrayList<>();
    }

    public void agregarAlimento(String nombre, int gramos) {
        Alimento alimento = new Alimento(nombre, gramos);
        alimentos.add(alimento);
    }

    public void ordenarAlimentosPorNombre() {
        Collections.sort(alimentos);
    }

    public void imprimirAlimentos() {
        for (Alimento alimento : alimentos) {
            System.out.println(alimento);
        }
    }

    public static void main(String[] args) {
        ListaAlimentos lista = new ListaAlimentos();
        lista.agregarAlimento("Manzana", 100);
        lista.agregarAlimento("Banana", 150);
        lista.agregarAlimento("Naranja", 120);

        lista.ordenarAlimentosPorNombre();
        lista.imprimirAlimentos();
    }
}