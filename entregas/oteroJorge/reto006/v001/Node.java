package v001;

public class Node {

    private String value;
    private Node next;
    private String extraValue;

    public Node(String value, String extraValue) {
        this.setValue(value);
        this.setExtraValue(extraValue);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public String getExtraValue() {
        return extraValue;
    }

    public void setExtraValue(String extraValue) {
        this.extraValue = extraValue;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
