public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Node iterator = first;
            while (iterator.getNext() != null) {
                count++;
                iterator = iterator.getNext();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insert(int value) {
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

    }

    public Node  deleteMidSide(int value){
        Node iterator= this.first;
        Node anterior= first;
        while (iterator!=null){
            if(value == iterator.getValue()){
                anterior.setNext(iterator.getNext());
                return iterator;
            }else{
                anterior=iterator;
            }
            iterator=iterator.getNext();
        }

        return null;
    }




    public int[] listAll() {
        int[] list = new int[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] =  iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

}
