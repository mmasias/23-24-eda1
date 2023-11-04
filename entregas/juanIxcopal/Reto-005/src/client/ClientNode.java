package client;

public class ClientNode {
    private int items;
    private ClientNode next;

    public ClientNode(int items) {
        this.setItems(items);
    }

    //GETERS
    public int getItems() {
        return items;
    }

    public ClientNode getNext() {
        return next;
    }

    //SETERS

    public void setItems(int newItem) {
        this.items = newItem;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }
}
