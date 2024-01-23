package arbolReto6;
public class Nodo<T> {
    private Nodo<T> siguiente;
    private T dato;
    private Lista<T> hijos;

    public Nodo(T dato) {
        this.dato = dato;
        this.hijos = new Lista<>();
    }

    @Override
    public String toString() {
        return dato.toString();
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> node) {
        this.siguiente = node;
    }

    public Lista<T> getHijos() {
        return hijos;
    }

    public T getDato() {
        return dato;
    }
}
