import java.time.LocalDate;

public class Encuesta {
    private LocalDate fecha;
    private GenericList<Dia> dias;

    public Encuesta(){
        this.dias= new GenericList<>();
    }

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
        this.dias= new GenericList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

   
    public String getInfo() {
        return "Fecha de encuesta: " + this.fecha.toString();
    }

    public GenericList<Dia> getDias() {
        return dias;
    }

    public void setDias(GenericList<Dia> dias) {
        this.dias = dias;
    }

    public void insertarDia(Dia d){
        this.dias.insertEnd(d);
    }
}
