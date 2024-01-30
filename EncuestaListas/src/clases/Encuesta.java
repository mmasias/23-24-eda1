package clases;

import Coleciones.IDataStructure;

import java.time.LocalDate;

public class Encuesta implements IDataStructure {
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
    public int compareTo(Ingesta o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getInformacion() {
        return "Fecha de la encuesta " + fecha.toString();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] listAll() {
        return new Object[0];
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
