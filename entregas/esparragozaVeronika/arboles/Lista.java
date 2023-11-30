package arboles;

public class Lista<T> {
    private Nodo<T> first;

    public Lista<T> insert(T data, int index) {
        if (first == null && (index == 0 || index == -1)) {
            first = new Nodo<>(data);
        } else if (index == 0) {
            insertFirst(new Nodo<>(data));
        } else if (index == -1) {
            insertLast(new Nodo<>(data));
        } else if (index > 0) {
            insertAt(new Nodo<>(data), index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void insertFirst(Nodo<T> node) {
        node.hijos.insert(node, 0);
    }

    private void insertLast(Nodo<T> node) {
        Nodo<T> last = first;
        while (last.hijos.getFirst() != null) {
            last = (Nodo<T>) last.hijos.getFirst();
        }
        last.hijos.insert(node, -1);
    }

    private void insertAt(Nodo<T> node, int index) {
        int i = 0;
        Nodo<T> current = first;
        while (i < index - 1 && current != null) {
            ++i;
            current = (Nodo<T>) current.hijos.getFirst();
        }
        if (current != null) {
            current.hijos.insert(node, -1);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Nodo<T> getFirst() {
        return first;
    }
}
