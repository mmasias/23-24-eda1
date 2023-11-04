package client;
import java.util.List;
public class ClientManager {

    private ClientList clients;
    private int clientId = 1;


    public ClientManager() {
        this.clients = new ClientList();
    }

    public void handleClientArrival() {
        double arrivalClient = Math.random() * 100;
        if (arrivalClient <= 60) {
            int randomItems = (int) Math.floor(Math.random()*(15-5+1)+5);
            clients.addClient(randomItems, clientId);
            clientId ++;
        }
    }

    public ClientNode getNextClient() {
        return clients.getNextClient();
    }

    public int clientsAmount(){
        return clients.size();
    }

    public List<Integer> listClientsInQueue(){
        return clients.listClients();
    }

    public int[] clientItems(){
        return clients.countItems();
    }

    //Nuevos métodos

    public int getClientItems(int clientId) {
        List<Integer> clientItems = clients.listClients();
        if (clientId >= 0 && clientId < clientItems.size()) {
            System.out.println("QUE ES ESTO " + clientItems.get(clientId));
            return clientItems.get(clientId);
        }
        return 0;
    }

    public void clientAttended(int index){
        clients.servedClient(index);
    }

}
