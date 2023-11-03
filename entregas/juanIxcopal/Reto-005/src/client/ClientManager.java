package client;

public class ClientManager {
    //ClientList clients = new ClientList();

    private ClientList clientList;

    public ClientManager() {
        this.clientList = new ClientList();
    }

    public void handleClientArrival() {
        // Lógica para manejar la llegada de un nuevo cliente
        double random = Math.random();
        if (random <= 0.60) { // Probabilidad del 60%
            int packs = (int) (Math.random() * 11) + 5; // Entre 5 y 15 packs
            clientList.addClient(packs);
        }
    }

    public ClientNode getNextClient() {
        // Devuelve el próximo cliente de la cola
        return clientList.getNextClient();
    }





    public void createCustomer(){
        int randomItems = (int) Math.floor(Math.random()*(15-5+1)+5);
        clientList.addClient(randomItems);
    }

    public int clientsAmount(){
        return clientList.size();
    }

    public int[] clientItems(){
        return clientList.countItems();
    }
}
