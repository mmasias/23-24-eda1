class Lista<T> {
    private NodoLista<T> first;
    private int size;

    public Lista() {
        first = null;
        size = 0;
    }

    public void add(T elemento) {
        NodoLista<T> nuevoNodo = new NodoLista<>(elemento);
        if (first == null) {
            first = nuevoNodo;
        } else {
            NodoLista<T> actual = first;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
        size++;
    }

    public T get(int indice) {
        NodoLista<T> actual = first;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getData();
            }
            actual = actual.getNext();
            contador++;
        }
        return null;
    }
    public NodoLista<T> getNode(int indice) {
        NodoLista<T> actual = first;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual;
            }
            actual = actual.getNext();
            contador++;
        }
        return null;
    }

    public void update(int indice, T data){
        getNode(indice).setData(data);
    }

    public void delete(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de límites: " + indice);
        }
        
        if (indice == 0) {
            first = first.getNext();
        } else {
            NodoLista<T> actual = first;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getNext();
            }
            actual.setNext(actual.getNext().getNext());
        }
        size--;
    }

    public void listAll() {
        NodoLista<T> actual = first;
        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }


    public int size() {
        return size;
    }
}