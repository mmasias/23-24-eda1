package arboles;

public class Nodo<T> {
    T dato;
    Lista<Nodo<T>> hijos;

    public Nodo(T dato) {
        this.dato = dato;
        this.hijos = new Lista<>();
    }
}
