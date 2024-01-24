package Coleciones;

import java.time.LocalDate;

public class NodoArbol<T extends IDataStructure> implements Comparable<NodoArbol<T>> {
    private T valor;
    private GenericList<NodoArbol<T>> hijos;
    private LocalDate fecha;
    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new GenericList<NodoArbol<T>>(null);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public T getValor() {
        return valor;
    }

    public GenericList<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoArbol<T> hijo) {
        this.hijos.insertEnd(hijo);
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
