package ccf;

public class List<T> {
    private Node<T> first = null;
    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node<T> iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean estaVacia() {
        return this.size() > 0 ? false : true;
    }

    public void insertar(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public Persona delete() {
        if (this.first != null) {
            Persona cliente = (Persona) this.first.getValue();
            this.first = this.first.getNext();
            return cliente;
        }
        return null;
    }
}