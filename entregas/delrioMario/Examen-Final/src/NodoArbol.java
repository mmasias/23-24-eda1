import java.util.ArrayList;
import java.util.List;

public class NodoArbol<T extends DatosArbol> implements Comparable<NodoArbol<T>> {
    private T valor;
    private List<NodoArbol<T>> hijos;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.add(hijo);
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public void insertEnd(NodoArbol<T> hijo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertEnd'");
    }

    
}