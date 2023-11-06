package client;

public class ClientManager {

    private ClientList queue;

    public ClientManager(){
        this.queue = new ClientList();
    }

    public void addClientInQueue(int item){
        queue.addClient(item);
    }

    public int firstItem(){
       return queue.getFirstItem();
    }

    public boolean isEmpty(){
      return queue.getIsEmpty();
    }

    public void deleteClientInQueue(){
        queue.deleteCLientInCole();
    }

    public int size(){
        return queue.size();
    }
}
