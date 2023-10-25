public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
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
    }

    public void insertInBetween(String value, int position){
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            int count = 0;
            while (iterator.getNext() != null && count != position) {
                iterator = iterator.getNext();
                count++;
            }
            if (iterator.getNext() == null)
                iterator.setNext(newNode);
            else {
                newNode.setNext(iterator.getNext());
                iterator.setNext(newNode);
            }
        }
    }

    public void deleteInBetween(int position){
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            int count = 0;
            while (iterator.getNext() != null && count != position) {
                previous = iterator;
                iterator = iterator.getNext();
                count++;
            }
            if (iterator.getNext() == null)
                previous.setNext(null);
            else {
                if (previous == null) {
                    this.first = iterator.getNext();
                }
                else {
                    if (iterator.getNext() != null) {
                        previous.setNext(iterator.getNext());
                    }
                }
            }
        }
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
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
