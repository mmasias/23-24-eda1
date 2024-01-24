package RetoExamenFinal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encuesta implements DatosLista {
    private LocalDate fecha;
    private List<Dia> dias;
    public Encuesta(LocalDate fecha){
        this.fecha= fecha;
        this.dias = new ArrayList();
    }
    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public List<Dia> getDias() {
        return dias;
    }

    @Override
    public String getInformacion() {
        return "Fecha de la encuesta: "+fecha.toString();
        
    }
    
}