package Reto007;

import java.util.ArrayList;
import java.util.List;

public class Ingestas {
    private List<Alimentos> alimentos;

    public Ingestas() {
        this.alimentos = new ArrayList<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentos.add(alimento);
    }

    public void mostrarAlimentos() {
        for (Alimentos alimento : alimentos) {
            System.out.println("             - " + alimento.getNombre());
        }
    }
}
