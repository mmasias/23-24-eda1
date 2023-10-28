package listas.generica;

public class NodoG<T> {

    private T dato;
    private NodoG<T> siguiente;

    public NodoG(T i) {
        this.setDato(i);
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoG<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoG<T> siguiente) {
        this.siguiente = siguiente;
    }
}
