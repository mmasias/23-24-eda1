package client;
import java.util.List;

public class ClientManager {
    private ClientList clients;

    public ClientManager() {
        this.clients = new ClientList();
    }

    public void clientArrival() {
        double arrivalClient = Math.random() * 100;
        if (arrivalClient <= 60) {
            int randomItems = (int) Math.floor(Math.random()*(15-5+1)+5);
            clients.addClient(randomItems);
            System.out.print("Llega 1 persona - ");
        } else {
            System.out.print("No llega nadie - ");
        }
    }

    public int size(){
        return clients.size();
    }
    public int[] clientItems(){
        return clients.getListClientItems();
    }

    public void deleteClient(){
        clients.deleteFront();
    }
}
