public class List<T extends Data> {
    private Node<T> first = null;
    private int length = 0;

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return this.getLength() < 0 ? true : false;
    }

    public void insert(Node<T> node) {
        if (this.first == null) {
            this.first = node;
        } else {
            Node<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(node);
        }
        this.length++;
    }

    public void remove() {
        if (this.first != null) {
            Node<T> iterator = this.first;
            Node<T> antecedent = null;
            while (iterator.getNext() != null){
                antecedent = iterator;
                iterator = iterator.getNext();
            }
            if (antecedent != null) {
                antecedent.setNext(null);
            } else {
                this.first = null;
            }
            this.length--;
        }
    }

    public void display() {
        if (this.first != null) {
            Node<T> iterator = this.first;
            while (iterator != null) {
                iterator.getData().printData();
                iterator = iterator.getNext();
            }
        }
    }
}
