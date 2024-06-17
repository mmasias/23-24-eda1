package ExamenFinal;

public class Node<T> {
    private T data;
    private int index;
    private Node<T> next;

    public Node(T data, int index) {
        this.data = data;
        this.index = index;
        this.next = null;
    }

    public int getIndex() {
        return index;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}