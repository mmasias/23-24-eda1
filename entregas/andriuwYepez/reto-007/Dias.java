import java.util.ArrayList;
import java.util.List;

public class Dias {
    private int numeroDia;
    private String fecha;
    private List<Ingestas> ingestas;
    private ArbolIngestas arbolIngestas;

    public Dias(int numeroDia, String fecha) {
        this.numeroDia = numeroDia;
        this.fecha = fecha;
        this.arbolIngestas = new ArbolIngestas();
    }

    public void agregarIngesta(Ingestas ingesta) {
        arbolIngestas.insertar(ingesta);
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Ingestas> getIngestas() {
        return ingestas;
    }

    public ArbolIngestas getArbolIngestas() {
        return arbolIngestas;
    }
}
