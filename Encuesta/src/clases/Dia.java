package clases;

import Coleciones.IDataStructure;

import java.time.LocalDate;

public class Dia implements IDataStructure {
    private int dia;
    private LocalDate fecha;

    public Dia(int dia) {
        this.dia = dia;

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getInformacion() {
        return "clases.Dia " + this.dia;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] listAll() {
        return new Object[0];
    }

}
