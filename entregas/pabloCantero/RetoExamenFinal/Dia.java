package RetoExamenFinal;
import java.util.List;
import java.util.ArrayList;
public class Dia implements DatosLista {
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
        return ingestas;
    }

    public void setIngestas(List<Ingesta> ingestas) {
        this.ingestas = ingestas;
    }

    @Override
    public String getInformacion() {
        return "Dia: " + this.fecha;
    }
}
