import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encuesta implements DatosArbol{
    private LocalDate fecha;
    private List<Encuesta> encuestas;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
        this.encuestas = new ArrayList<>();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public List<Encuesta> getEncuestas() {
        return this.encuestas;
    }

    public void addEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    @Override
    public String getInformacion() {
        return "Fecha de la encuesta: "+ fecha.toString();
    }
}