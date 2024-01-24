package clases;

import Coleciones.IDataStructure;

import java.time.LocalDate;

public class Persona implements IDataStructure {
    private String nombre;
    private LocalDate fechaAlta;

    public Persona(String nombre, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getInformacion() {
        return "Paciente: " + this.nombre + " - Fecha de alta: " + this.fechaAlta.toString();
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
