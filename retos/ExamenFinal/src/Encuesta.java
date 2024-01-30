import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encuesta implements DatosArbol {
    private LocalDate fecha;
    private List<Dia> dias;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
        this.dias = new ArrayList<>();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public List<Dia> getDias() {
        return this.dias;
    }

    public void addDia(Dia dia) {
        this.dias.add(dia);
    }

    @Override
    public String getInformacion() {
        return "Fecha de la encuesta: " + fecha.toString();
    }
}
