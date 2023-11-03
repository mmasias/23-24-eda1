import client.ClientManager;
import cashier.CashierManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // ----------- CLIENTES ----------------//
        ClientManager clients = new ClientManager();

        clients.createCustomer();
        clients.createCustomer();
        clients.createCustomer();
        clients.createCustomer();
        clients.createCustomer();


        // ----------- CAJAS ---------------- //
        CashierManager cashier = new CashierManager();

        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");

        System.out.println("Cantidad de clientes: " + clients.clientsAmount());

        System.out.println("Cantidad de items de cada cliente: ");
        clients.clientItems();

        System.out.println("Cajas creadas: ");
        cashier.listCashiers();
    }
}