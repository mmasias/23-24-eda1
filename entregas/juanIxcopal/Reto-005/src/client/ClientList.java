package client;

public class ClientList {
    private int size = 0;
    private ClientNode first = null;

    public int size(){
        return this.size;
    }
    public void addClient(int item){
        ClientNode newClient = new ClientNode(item);
        if (this.first == null){
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

    public void deleteEnd(){
        if (this.first != null){
            ClientNode iterator = this.first;
            ClientNode previous = null;
            while (iterator.getNext() != null){
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null){
                previous.setNext(null);
            } else {
                this.first = null;
            }
            System.out.println("Prueba delete end " + iterator.getItems());
            this.size--;
        }
    }
    public void deleteFront(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size--;
        }else {
            System.out.println("Prueba delete front " + this.first.getItems());
        }
    }

    public int[] getListClientItems(){
        int[] list = new int[this.size];
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
