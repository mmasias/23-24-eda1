package Coleciones;

public class GenericNode<T> {

    private T value;
    private GenericNode<T> next;

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
    public void insertarHijos(GenericNode<T> nuevoHijo) {
        this.next.insertarHijos(nuevoHijo);
    }

    public void setNext(GenericNode<T> siguiente) {
        this.next = siguiente;
    }
}