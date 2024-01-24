import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dia implements DatosLista {
    private LocalDate fecha;
    private List<Ingesta> ingestas;

    public Dia(LocalDate fecha) {
        this.fecha = fecha;
        this.ingestas = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
        return "Día: " + this.fecha;
    }

    public static void main(String[] args) {
        LocalDate fechaHoy = LocalDate.now();
        Dia dia = new Dia(fechaHoy);
        
        Ingesta ingesta1 = new Ingesta("Desayuno", "Cereal", 200);
        Ingesta ingesta2 = new Ingesta("Almuerzo", "Pollo", 300);
        
        dia.getIngestas().add(ingesta1);
        dia.getIngestas().add(ingesta2);
        
        System.out.println(dia.getInformacion());
        for (Ingesta ingesta : dia.getIngestas()) {
            System.out.println(ingesta.getInformacion());
        }
    }
}