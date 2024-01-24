import java.util.ArrayList;
import java.util.List;  

public class Dia {
    private List<Ingesta> ingestas = new ArrayList<>();

    public List<Ingesta> getIngestas() {
        return ingestas;
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta);
    }
}
