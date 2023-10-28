public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(String value) {
        Node nodoQueEntra = new Node(value);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        System.out.println(" > Llegó " + value);
        this.size++;
    }

    public void insertAtBeginning(String value) {
        Node newNode = new Node(value);
        newNode.setNext(this.first);
        this.first = newNode;
        this.size++;
        System.out.println(" > Llegó " + value + " al principio");
    }

    public void insertAt(int index, String value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node(value);
        Node iterator = this.first;
        for (int i = 0; i < index - 1; i++) {
            iterator = iterator.getNext();
        }
        newNode.setNext(iterator.getNext());
        iterator.setNext(newNode);
        this.size++;
        System.out.println(" > Llegó " + value + " en la posición " + index);
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println("Se fue " + iterator.getValue());
            previous.setNext(null);
            this.size--;
        }
    }

    public void deleteFirst() {
        if (this.first != null) {
            System.out.println("Se fue " + this.first.getValue() + " desde el principio");
            this.first = this.first.getNext();
            this.size--;
        }
    }

    public void deleteLast() {
        if (this.first != null) {
            if (this.size == 1) {
                deleteFirst();
                return;
            }

            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            System.out.println("Se fue " + iterator.getValue() + " desde el final");
            previous.setNext(null);
            this.size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
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
}