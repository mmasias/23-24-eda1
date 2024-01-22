public class DaysNode {
    private String day;
    private DaysNode next;

    public DaysNode(String value) {
        this.setValue(value);
    }

    public String getDay() {
        return day;
    }

    public void setValue(String newValue) {
        this.day = newValue;
    }

    public DaysNode getNext() {
        return next;
    }

    public void setNext(DaysNode next) {
        this.next = next;
    }
}
