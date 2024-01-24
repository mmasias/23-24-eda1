package ExamenFinal;

public class List<T> {

    private Node<T> first;

    public List<T> insert(T data, int index) {
        if (first == null && (index == 0 || index == -1)) {
            first = new Node<>(data);
        } else if (index == 0) {
            insertFirst(new Node<>(data));
        } else if (index == -1) {
            insertLast(new Node<>(data));
        } else if (index > 0) {
            insertAt(new Node<>(data), index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void insertFirst(Node<T> node) {
        node.setNext(first);
        first = node;
    }

    private void insertLast(Node<T> node) {
        if (first == null) {
            first = node;
        } else {
            Node<T> last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    private void insertAt(Node<T> node, int index) {
        int i = 0;
        Node<T> current = first;
        while (i < index - 1 && current != null) {
            ++i;
            current = current.getNext();
        }
        if (current != null) {
            node.setNext(current.getNext());
            current.setNext(node);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<T> remove(int index) {
        if (getFirst() != null) {
            if (index == 0) {
                removeFirst();
            } else if (index == -1) {
                removeLast();
            } else {
                removeAt(index);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    private void removeLast() {
        if (first != null) {
            if (first.getNext() != null) {
                Node<T> oneBeforeLast = first;
                while (oneBeforeLast.getNext() != null && oneBeforeLast.getNext().getNext() != null) {
                    oneBeforeLast = oneBeforeLast.getNext();
                }
                oneBeforeLast.setNext(null);
            } else {
                first = null;
            }
        }
    }

    private void removeAt(int index) {
        Node<T> current = first;
        for (int i = 0; i < index - 1; ++i) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if (current.getNext() == null) {
            throw new IndexOutOfBoundsException();
        }
        current.setNext(current.getNext().getNext());
    }

    public Node<T> getFirst() {
        return first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        if (first != null) {
            return first.count();
        } else {
            return 0;
        }
    }

    public String[] listData() {
        String[] array = new String[size()];

        Node<T> node = first;
        int i = 0;
        while (node != null) {
            array[i++] = String.valueOf(node.getData());
            node = node.getNext();
        }

        return array;
    }

}