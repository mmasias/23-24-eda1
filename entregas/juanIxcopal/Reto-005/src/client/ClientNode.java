package client;

public class ClientNode {
    private int items;
    private ClientNode next;

    public ClientNode(int items) {
        this.setItems(items);
    }

    public int getItems() {
        return items;
    }

    public void setItems(int newItem) {
        this.items = newItem;
    }

    public ClientNode getNext() {
        return next;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }
}
