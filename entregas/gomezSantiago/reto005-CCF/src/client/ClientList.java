package client;

public class ClientList {
    private int size = 0;
    private ClientNode first = null;

    public int size(){
        return this.size;
    }

    public void addClient(int item) {
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
        this.size++;
    }

    public int getFirstItem(){
        if(this.first != null){
            return this.first.getItems();
        }
        return 0;
    }

    public boolean getIsEmpty(){

        if(this.first != null){
            return true;
        } else {
            return false;
        }
    }


    //Crear metodos de eliminar primero
    public void deleteCLientInCole(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size--;
        }
    }
}
