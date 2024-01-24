package RetoExamenFinal;
import java.time.LocalDate;
public class Encuesta implements DatosLista {
    private LocalDate fecha;
    public Encuesta(LocalDate fecha){
        this.fecha= fecha;
    }
    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String getInformacion() {
        return "Fecha de la encuesta: "+fecha.toString();
        
    }
    
}