package client;

public class ClientList {

    private ClientNode first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void addClient(int item){
        ClientNode newClient = new ClientNode(item);
        if (this.first == null) {
            this.first = newClient;
        } else {
            ClientNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newClient);
        }
        this.size ++;
    }

    public ClientNode getNextClient(){
        if(this.first != null){
            System.out.println("Un cliente ha sido atendido");
            this.first = this.first.getNext();
            this.size --;
        }
        return this.first;
    }

    /*el método attendClient es igual a getNextClient*/
    //Modificar y usar attendClient
    public void attendClient(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size --;
        }
    }

    public int[] countItems(){
        int[] list = new int[this.size()];
        ClientNode iterator = this.first;
        int count = 0;

        while (iterator != null){
            list[count] = iterator.getItems();
            System.out.println(iterator.getItems());
            count ++;
            iterator = iterator.getNext();
        }

        return list;
    }
}
