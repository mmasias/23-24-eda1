package Coleciones;

public class NodoArbol<T extends IDataStructure> implements Comparable<NodoArbol<T>> {
    private T valor;
    private GenericList<NodoArbol<T>> hijos;

    public NodoArbol(T valor) {
        this.valor = valor;
        this.hijos = new GenericList<NodoArbol<T>>();
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
