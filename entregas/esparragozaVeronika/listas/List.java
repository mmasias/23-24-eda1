package listas;

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
        System.out.println("> Llegó al inicio " + newNode.getValue());
    }

    public void deleteBack() {
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

    public void deleteFront() {
        System.out.println("Se fue " + first.getValue());
        if (first != null) {
            first = first.getNext();
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

    public void insertAtIndex(int index, String value) {
        if (index < 0){
            System.out.println("No válido, es menor de 0.");
        } else if(index == 0){
            insertFront(value);
        } else {
            int count = 1;
            Node newNode = new Node(value);
            Node iterator = first;

            while (iterator != null && count < index - 1) {
                iterator = iterator.getNext();
                count++;
            }

            if(iterator == null){
                System.out.println("No válido, la lista no tiene posición "+index);
            } else {
                newNode.setNext(iterator.getNext());
                iterator.setNext(newNode);
                System.out.println("> Llegó " + value + " en la posición " + index);
            }
        }
    }
}