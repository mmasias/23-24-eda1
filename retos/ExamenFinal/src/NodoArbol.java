import java.util.ArrayList;
import java.util.List;

public class NodoArbol<T extends DatosArbol> implements Comparable<NodoArbol<T>> {
    private T value;
    private List<NodoArbol<T>> hijos;

    public NodoArbol(T value) {
        this.value = value;
        this.hijos = new ArrayList<>();
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        // Implementación básica de compareTo comparando los valores de los nodos
        return this.value.getInformacion().compareTo(o.value.getInformacion());
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public void insertarHijo(NodoArbol<T> hijo) {
        hijos.add(hijo);
    }
}
