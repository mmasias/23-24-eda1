package listas.basica;

public class List<T> {

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
    public Node<T>  deleteMidSide(T value){
        Node<T> iterator= this.first;
        Node<T> anterior= first;
        while (iterator!=null){
            if(iterator.getValue()==value){
                anterior.setNext(iterator.getNext());
                return iterator;
            }else{
                anterior=iterator;
            }
            iterator=iterator.getNext();
        }

        return null;
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
    public void deleteFirst(){
        first=first.getNext();

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
        Node<T> iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = String.valueOf(iterator.getValue());
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
