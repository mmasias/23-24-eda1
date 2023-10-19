package entregas.garcíaDiego.Ex003;

public class List {

    private Node first = null;
    private int size = 0;



    public int size() {
       return this.size;
    }


    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
        System.out.println(" > Llegó " + value);
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
                System.out.println("Se fue " + iterator.getValue());
            } else {
                this.first = null;
                System.out.println("Se fue " + iterator.getValue());
            }
            this.size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
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
