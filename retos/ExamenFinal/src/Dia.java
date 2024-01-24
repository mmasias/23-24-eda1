import java.util.ArrayList;
import java.util.List;

public class Dia implements DatosArbol, Comparable<Dia>{
    private int fecha;
    private List<Dia> dias;

    public Dia(int fecha) {
        this.fecha = fecha;
        this.dias = new ArrayList<>();
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public List<Dia> getDias() {
        return this.dias;
    }

    public void addDia(Dia dia) {
        this.dias.add(dia);
    }

    @Override
    public String getInformacion() {
        return "Dia: "+ this.fecha;
    }

    @Override
    public int compareTo(Dia o) {
        if (this.fecha>o.fecha) {
            return 1;
        }else if (this.fecha<o.fecha) {
            return -1;
        }else {
            return 0;
        }
    }
}