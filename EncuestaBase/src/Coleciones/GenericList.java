package Coleciones;

import Coleciones.GenericNode;

import java.util.Iterator;

public class GenericList<T extends Comparable<T>> extends DataStructure<T> implements Iterable<T> {

    private GenericNode<T> first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        GenericNode<T> iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    @Override
    public String getInformacion() {
        return null;
    }

    public void insertFront(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            GenericNode<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public GenericNode<T> getFirst() {
        return this.first;
    }

    public GenericNode<T> getLast() {
        GenericNode<T> iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    /*
     * @SuppressWarnings("unchecked") Esto le indica al compilador que estás
     * consciente de la situación y estás
     * asumiendo la responsabilidad de garantizar la seguridad del tipo.
     */
    // @SuppressWarnings("unchecked")
    public Object[] listAll() {
        Object[] list = new Object[this.size()];
        // T[] list = (T[]) Array.newInstance(this.first.getValue().getClass(),
        // this.size());
        GenericNode<T> iterator = this.first;

        if (iterator == null)
            return list;

        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public void insertOrdered(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);

        // Si la lista está vacía o el nuevo nodo debe ir al frente
        if (this.first == null || value.compareTo(this.first.getValue()) < 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            GenericNode<T> current = this.first;
            GenericNode<T> previous = null;

            // Buscar la posición adecuada para insertar el nuevo nodo
            while (current != null && value.compareTo(current.getValue()) >= 0) {
                previous = current;
                current = current.getNext();
            }

            // Insertar el nuevo nodo
            newNode.setNext(current);
            if (previous != null) {
                previous.setNext(newNode);
            }
        }
    }

    public T getValorPorPosicion(int pos) {
        if (this.first == null)
            throw new IndexOutOfBoundsException();

        GenericNode<T> actual = this.first;
        int contador = 0;
        do {
            if (contador == pos) {
                return actual.getValue();
            }
            contador++;
            actual = actual.getNext();
        } while (actual != null);
        // Si llego aquí no lo he encotradi
        throw new IndexOutOfBoundsException();

    }
public void vaciar(){
        if (!isEmpty()){
            GenericNode<T> actual=this.first;
            do {
                this.deleteFront();
                actual=this.first;
            }while (actual!=null);
        }
}
    public int indexOf(T value) {
        GenericNode<T> iterator = this.first;
        int index = 0;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return index; // Encontrado, devuelve la posición
            }
            iterator = iterator.getNext();
            index++;
        }

        return -1; // No encontrado
    }

    public void updateValueByPosition(int position, T newValue) {
        int size = this.size();

        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición no válida");
        }

        GenericNode<T> iterator = this.first;
        int index = 0;

        while (iterator != null) {
            if (index == position) {
                iterator.setValue(newValue); // Actualiza el valor del nodo en la posición dada
                return;
            }
            iterator = iterator.getNext();
            index++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private GenericNode<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                // Puedo lanzar una excepción o manejarlo de alguna otra manera
                return null;
            }
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

    }

}
