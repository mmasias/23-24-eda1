import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numeroDia;
    private List<Ingesta> ingestas;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new ArrayList<>();
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta);
    }

    public List<Ingesta> getIngestas() {
        return ingestas;
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Dia ").append(numeroDia).append("\n");
        for (Ingesta ingesta : ingestas) {
            sb.append(ingesta.toString());
        }
        return sb.toString();
    }
}
