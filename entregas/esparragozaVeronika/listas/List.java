package esparragozaVeronika.listas;

public class List {

    private Node first = null;

    public int size() {
        int count = 0;
        Node iterator = first;
        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() { return size() == 0; }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        System.out.println("> Llegó " + newNode.getValue());
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;
    }

    public void delete() {
        if (first != null) {
            if (first.getNext() == null) {
                first = null;
            } else {
                Node iterator = first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null);
            }
            System.out.println("Se fue " + first.getValue());
        }
    }

    public String[] listAll() {
        int listSize = size();
        String[] list = new String[listSize];
        Node iterator = first;
        for (int i = 0; i < listSize; i++) {
            list[i] = iterator.getValue();
            iterator = iterator.getNext();
        }
        return list;
    }
}