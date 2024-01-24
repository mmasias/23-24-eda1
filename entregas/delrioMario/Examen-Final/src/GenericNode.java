public class GenericNode<T extends DatosArbol> implements Comparable<NodoArbol<T>> {

    private T value;
    private GenericNode<T> next;
    private NodoArbol<T> hijos;

    public GenericNode(T value) {
        this.setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T newValue) {
        this.value = newValue;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> siguiente) {
        this.next = siguiente;
    }

    public void insertarHijos(NodoArbol<T> hijo) {
        hijos.insertEnd(hijo);
    }

    public void setHijos(NodoArbol<T> hijos) {
        this.hijos = hijos;
    }
    public NodoArbol<T> getHijos() {
        return hijos;
    }

    @Override
    public int compareTo(NodoArbol<T> o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public void insertarHijos(Object hijo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertarHijos'");
    }

}