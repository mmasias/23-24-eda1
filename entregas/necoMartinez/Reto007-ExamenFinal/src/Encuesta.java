package src;

import java.time.LocalDate;

public class Encuesta {
    private LocalDate fecha;

    public Encuesta(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Fecha de la encuesta: " + fecha.toString();
    }
}
