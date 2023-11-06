package client;

public class ClientNode {
    private int items;
    private ClientNode next;

    public ClientNode(int items) {
        this.setItems(items);
    }

    public int getItems(){
        return items;
    }

    public ClientNode getNext(){
        return next;
    }
    public void setItems(int newItems){
        this.items = newItems;
    }

    public void setNext(ClientNode next) {
        this.next = next;
    }
}
