package listas.generica;

import listas.generica.NodoG;

public class ListG<T> {

    private NodoG<T> first = null;

    public ListG() {

    }

    public int Size() {
        if (this.first == null)
            return 0;

        int count = 1;
        NodoG<T> iterator = first;
        while (iterator.getSiguiente() != null) {
            count++;
            iterator = iterator.getSiguiente();
        }
        return count;
    }

    public boolean IsEmpty() {
        return this.Size() > 0 ? false : true;
    }

    public void InsertIni(T dato) {
        NodoG<T> n = new NodoG<T>(dato);
        if (this.first == null)
            this.first = n;
        else {
            n.setSiguiente(this.first);
            this.first = n;
        }
    }

    public void InsertEnd(T dato) {
        NodoG<T> n = new NodoG<T>(dato);
        if (this.first == null)
            this.first = n;
        else {
            NodoG<T> iterator = this.first;
            while (iterator.getSiguiente() != null) {
                iterator = iterator.getSiguiente();
            }
            iterator.setSiguiente(n);
        }
    }

    public void DeleteIni() {
        if (this.first != null) {
            this.first = this.first.getSiguiente();
        }
    }

    public NodoG<T> GetFirst() {
        return this.first;
    }

    public T[] ListAll() {

        T[] list = (T[]) new Object[this.Size()];
        NodoG<T> iterator = this.first;

        if (iterator == null)
            return list;

        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getDato();
            count++;
            iterator = iterator.getSiguiente();
        }
        return list;
    }    

}
