public class List {

    private Node first;
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
        return this.size() <= 0;
    }
    public String[] listAll() {
        String[] larray = new String[this.size()];
        Node iterator = this.first;
        int i = 0;
        while (iterator != null) {
            larray[i] = iterator.getValue();
            iterator = iterator.getNext();
            i++;
        }
        return larray;
    }
}