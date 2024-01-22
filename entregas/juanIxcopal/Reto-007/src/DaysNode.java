public class DaysNode {
    private String day;
    private DaysNode next;

    public DaysNode(String value) {
        this.setValueDay(value);
    }

    public String getDay() {
        return day;
    }

    public DaysNode getNextDay() {
        return next;
    }

    public void setValueDay(String newValue) {
        this.day = newValue;
    }

    public void setNextDay(DaysNode next) {
        this.next = next;
    }
}
