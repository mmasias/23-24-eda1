package clases;

import Coleciones.GenericList;
import Coleciones.IDataStructure;

public class Ingesta implements  IDataStructure {
    private Horario horario;
    private GenericList<Alimento> alimentos;

    public Ingesta(Horario horario) {
        this.horario = horario;
        this.alimentos = new GenericList<Alimento>();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public GenericList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void insertarAlimento(Alimento alimento) {
        this.alimentos.insertOrdered(alimento);
    }

    @Override
    public int compareTo(Ingesta o) {
        if (this.getHorario().getNumero() < o.horario.getNumero())
            return -1;
        else if (this.getHorario().getNumero() > o.horario.getNumero())
            return 1;

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getInformacion() {
        String texto = this.getHorario().getNombre() + ": ";
        for (Alimento alimento : this.getAlimentos()) {
            texto += alimento.getNombre() + "(" + alimento.getMg() + "mg), ";
        }
        return texto.substring(0, texto.length() - 2); // quito los dos ultimos caracteres
    }

    @Override
    public void insertarHijos(IDataStructure hijo) {

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
    public void setValue(Persona persona) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
