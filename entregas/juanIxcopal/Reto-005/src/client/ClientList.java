package client;
import java.util.List;
import java.util.ArrayList;

public class ClientList {

    private ClientNode first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void addClient(int item, int numberClient){
        ClientNode newClient = new ClientNode(item, numberClient);
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
            this.first = this.first.getNext();
            this.size --;
        }
        return this.first;
    }

    public int getItems(){
        ClientNode iterator = this.first;

        while (iterator != null){
            System.out.println("getItems" + iterator.getItems());
            iterator = iterator.getNext();
        }

        return iterator.getItems();
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

    //Nuevos metodos

    public List<Integer> listClients(){
        List<Integer> clients = new ArrayList<Integer>();

        ClientNode iterator = this.first;

        while (iterator != null){
            clients.add(iterator.getNumberClient());
            iterator = iterator.getNext();
        }
        return clients;
    }

    public void servedClient(int index){
        if (index == 0) {
            deleteFront();
        } else if (index == size - 1) {
            deleteEnd();
        } else {
            ClientNode iterator = this.first;
            int count = 0;
            while (count < index - 1) {
                iterator = iterator.getNext();
                count++;
            }
            ClientNode nodeToDelete = iterator.getNext();
            iterator.setNext(nodeToDelete.getNext());
            this.size--;
        }
    }

    public void deleteFront(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size --;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            ClientNode iterator = this.first;
            ClientNode previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null;
            }
            this.size--;
        }
    }
}
