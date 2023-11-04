import client.ClientManager;
import cashier.CashierManager;

import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean openMarket = true;

        ClientManager clients = new ClientManager();
        CashierManager cashier = new CashierManager();

        // ----------- CAJAS ---------------- //
        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");

        while (openMarket){

            clients.handleClientArrival();


            System.out.println("Cajas libres" + cashier.listAvailableCashiers());

            System.out.println("Clientes en cola: " + clients.listClientsInQueue());

            List<Integer> clientsInQueue = clients.listClientsInQueue();
            for(Integer clientId : clientsInQueue){
                int items = clients.getClientItems(clientId);
                System.out.println("Cliente No." + clientId + " Items: " + items);

                System.out.println("Cantidad de items de cada cliente: ");
                clients.clientItems();
                //cashier.proccessClient(clientId, items, clients);
            }

            //cashier.atenderCliente(clients.listClientsInQueue());


            System.out.print("¿Desea cerrar el programa? (Sí/No): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("si") || respuesta.equals("sí")) {
                openMarket = false; // El programa se cerrará
            }

            System.out.println("---------------------------" + "\n");
        }
    }
}


/*System.out.println("clientes en cola: " + clients.clientsAmount());

            System.out.println("Cantidad de items de cada cliente: ");
            clients.clientItems();

            System.out.println("Cajas disponibles: ");
            cashier.listCashiers();*/


/*System.out.println("Cantidad de items de cada cliente: ");
        clients.clientItems();

        System.out.println("Cajas creadas: ");
        cashier.listCashiers();*/