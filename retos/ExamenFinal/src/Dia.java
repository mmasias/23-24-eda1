import java.util.ArrayList;
import java.util.List;

public class Dia implements DatosArbol, Comparable<Dia> {
    private int fecha;
    private List<Ingesta> ingestas;

    public Dia(int fecha) {
        this.fecha = fecha;
        this.ingestas = new ArrayList<>();
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public List<Ingesta> getIngestas() {
        return this.ingestas;
    }

    public void addIngesta(Ingesta ingesta) {
        this.ingestas.add(ingesta);
    }

    @Override
    public String getInformacion() {
        return "Día: " + this.fecha;
    }

    @Override
    public int compareTo(Dia o) {
        return Integer.compare(this.fecha, o.fecha);
    }
}
