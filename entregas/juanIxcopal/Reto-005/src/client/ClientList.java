package client;

public class ClientList {
    private int size = 0;
    private ClientNode first = null;

    public int size(){
        return this.size;
    }

    public void addClient(int items) {
        ClientNode newClient = new ClientNode(items);
        if (this.first == null) {
            this.first = newClient;
        } else {
            ClientNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newClient);
        }
        this.size++;
    }

    public void deleteFront(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size --;
        }
    }

    public int[] getListClientItems(){
        int[] list = new int[this.size()];

        ClientNode iterator = this.first;

        int count = 0;

        while (iterator != null){
            list[count] = iterator.getItems();
            count ++;
            iterator = iterator.getNext();
        }

        return list;
    }
}