package client;

public class ClientNode {
    private int items;
    private int numberClient;
    private ClientNode next;

    public ClientNode(int items, int numberClient) {
        this.setItems(items);
        this.numberClient = numberClient;
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

    public int getNumberClient(){
        return numberClient;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }
}
