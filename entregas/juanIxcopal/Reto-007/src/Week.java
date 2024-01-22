public class Week {
    private DaysNode first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void insertDay(String value) {
        DaysNode newNode = new DaysNode(value);
        if (this.first == null) {
            this.first = newNode ;
        } else {
            DaysNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size ++;
    }

    public String[] listDays() {
        String[] list = new String[this.size()];
        DaysNode iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getDay();
            System.out.println(iterator.getDay());
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

}
