public class List<T> {
    private Node<T> head;
    private int size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data, size + 1);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        size++;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println("Index: " + current.getIndex() + ", Data: " + current.getData());
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }
}
