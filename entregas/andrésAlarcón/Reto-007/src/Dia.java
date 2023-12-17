import java.util.HashMap;
import java.util.Map;

public class Dia {
    Map<String, Ingesta> ingestasPorTipo;

    public Dia() {
        this.ingestasPorTipo = new HashMap<>();
    }

    public void agregarIngesta(String tipo, Ingesta ingesta) {
        ingestasPorTipo.put(tipo, ingesta);
    }

    public Ingesta obtenerIngesta(String tipo) {
        return ingestasPorTipo.get(tipo);
    }
}
