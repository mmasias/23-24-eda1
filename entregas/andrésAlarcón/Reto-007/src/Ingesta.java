import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ingesta {
    Map<String, List<Alimento>> alimentosPorTipo;

    public Ingesta() {
        this.alimentosPorTipo = new HashMap<>();
    }

    public void agregarAlimento(String tipo, Alimento alimento) {
        alimentosPorTipo.computeIfAbsent(tipo, k -> new ArrayList<>()).add(alimento);
    }

    public List<Alimento> obtenerAlimentos(String tipo) {
        return alimentosPorTipo.getOrDefault(tipo, new ArrayList<>());
    }
}
