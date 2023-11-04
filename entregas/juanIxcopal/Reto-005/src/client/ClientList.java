package client;

import java.util.List;
import java.util.ArrayList;

public class ClientList {
    private int size = 0;
    private ClientNode first = null;
    private ClientNode current;

    public int size(){
        return this.size;
    }

    public void addClient(int items){
        ClientNode newClient = new ClientNode(items);
        if (this.first == null) {
            this.first = newClient;
            this.current = newClient;
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

    public void deleteClientAtIndex(int index){
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

    public void removeClient(){
        if(this.current == null){
            throw new IllegalArgumentException("No current client to remove.");
        }
        if(this.first == current){
            deleteFront();
        } else {
            ClientNode iterator = this.first;

            while (iterator.getNext() != this.current){
                iterator = iterator.getNext();
            }
            iterator.setNext(current.getNext());
            size--;
            current = current.getNext();

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

    public void deleteFront(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size --;
        }
    }

    public int[] getListClientItems(){
        int[] list = new int[this.size()];

        System.out.println("SIZEEEEEE: " + this.size);

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



/*public int getItemsForClient(int numberClient){
        ClientNode iterator = this.first;
        int index = 0;

        while (iterator != null){
            if(index == numberClient - 1){
                //Aqui se elimina uno en uno el item del cliente seleccionado
                iterator.setItems(iterator.getItems() - 1);
                if (iterator.getItems() <= 0){
                    // Eliminar al cliente por que el item es 0
                    deleteClientAtIndex(numberClient - 1);
                }
                return iterator.getItems();
            }
            iterator = iterator.getNext();
            index ++;
        }
        throw new IllegalArgumentException("Cliente no encontrado");
    }*/