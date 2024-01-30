package Coleciones;

import clases.Alimento;
import clases.Ingesta;

import java.util.Iterator;

public class GenericList<T extends Comparable<T>> extends DataStructure<T> implements Iterable<T> {

    private GenericNode<T> first = null;

    public GenericList(GenericNode<T> first) {
        this.first = first;
    }

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

    @Override
    public int compareTo(Ingesta o) {
        return 0;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    @Override
    public String getInformacion() {
        return null;
    }

    @Override
    public void insertarHijos(IDataStructure hijo) {

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
    public void setValor(int index, T nuevoValor) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        GenericNode<T> actual = first;
        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }

        actual.setValue(nuevoValor);
    }
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        GenericNode<T> actual = first;
        for (int i = 0; i < index; i++) {
            actual = actual.getNext();
        }

        return actual.getValue();
    }
    public int buscarElemento(String elemento) {

        if (this.first == null)
            return -1;
        else {
            GenericNode<T> iterator = this.first;
            while (iterator.getNext() != null) {

                Alimento a=(Alimento)iterator.getValue();
                if (a.getNombre().equalsIgnoreCase(elemento)){
                    return a.getMg();
                }
                iterator = iterator.getNext();

            }
        }return -1;
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


    public Object[] listAll() {
        Object[] list = new Object[this.size()];

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

        if (this.first == null || value.compareTo(this.first.getValue()) < 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            GenericNode<T> current = this.first;
            GenericNode<T> previous = null;
            while (current != null && value.compareTo(current.getValue()) >= 0) {
                previous = current;
                current = current.getNext();
            }

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

        throw new IndexOutOfBoundsException();

    }
    public int indexOf(T value){
        GenericNode<T> iterator=this.first;
        int index=0;
        while (iterator!=null){
            if (iterator.getValue().equals(value)){
                return index;
            }
            if (iterator.getValue() instanceof String){
                if (((String) iterator.getValue()).equalsIgnoreCase((String) value)){
                    return index;
                }
            }
            iterator=iterator.getNext();
            index++;
        }
        return -1;
    }
    public void vaciar(){
        this.first=null;
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
                iterator.setValue(newValue);
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

    @Override
    public int compareTo(IDataStructure o) {
        return 0;
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

                return null;
            }
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

    }

}
