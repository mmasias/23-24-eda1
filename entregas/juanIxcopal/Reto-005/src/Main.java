import client.ClientManager;
import cashier.CashierManager;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int minuto = 1;

        ClientManager client = new ClientManager();
        CashierManager cashier = new CashierManager();

        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");


        Scanner scanner = new Scanner(System.in);
        boolean openCarrefour = true;


        while (openCarrefour) {

            System.out.print("MINUTO " + minuto + " - ");
            client.clientArrival();
            System.out.println("En cola: " + client.size());

            if (cashier.hasAvailableCashier() && client.size() > 0) {
                cashier.dispatchCustomer(client.clientItems(), client);
            }

            cashier.listCashiers();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            //System.out.println("Clientes en cola: " + java.util.Arrays.toString(client.clientItems()));
            System.out.println("1. Llegada de cliente");
            System.out.println("2. Cerrar programa");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    openCarrefour = true;
                    break;
                case 2:
                    openCarrefour = false;
                    break;
                default:
                    System.out.println("Opcion no valida");

            }

            minuto++;
        }
    }
}