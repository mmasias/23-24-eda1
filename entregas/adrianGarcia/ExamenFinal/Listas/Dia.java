import java.util.ArrayList;
import java.util.List;

public class Dia {
    private int numeroDia;
    private List<Ingesta> ingestas;

    public Dia(int numeroDia) {
        this.numeroDia = numeroDia;
        this.ingestas = new ArrayList<>();
        agregarIngesta(new Ingesta("Desayuno", null));
        agregarIngesta(new Ingesta("Media mañana", null));
        agregarIngesta(new Ingesta("Almuerzo", null));
        agregarIngesta(new Ingesta("Merienda", null));
        agregarIngesta(new Ingesta("Cena", null));
    }

    public void agregarIngesta(Ingesta ingesta) {
        ingestas.add(ingesta);
    }

    public Ingesta buscarIngesta(String tipoComida) {
        for (Ingesta ingesta : ingestas) {
            if (ingesta.getTipoComida().equalsIgnoreCase(tipoComida)) {
                return ingesta;
            }
        }
        return null;
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Dia ").append(numeroDia).append("\n");

        String[] comidas = {"Desayuno", "Media mañana", "Almuerzo", "Merienda", "Cena"};
        for (String comida : comidas) {
            Ingesta ingesta = buscarIngesta(comida);
            sb.append(ingesta.toString());
        }
        return sb.toString();
    }
}

