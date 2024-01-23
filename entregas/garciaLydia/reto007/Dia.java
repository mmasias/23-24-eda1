package entregas.garciaLydia.reto007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dia {
    private int numero;
    private Map<String, List<Alimento>> ingesta;

    public Dia(int numero) {
        this.numero = numero;
        this.ingesta = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void agregarAlimento(String tipoIngesta, Alimento alimento) {
        ingesta.computeIfAbsent(tipoIngesta, k -> new ArrayList<>()).add(alimento);
    }

    public Map<String, List<Alimento>> getIngesta() {
        return ingesta;
    }
}

