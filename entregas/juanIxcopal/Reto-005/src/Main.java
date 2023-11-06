import cashier.CashierManager;
import client.ClientManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int minute = 1;
        ClientManager client = new ClientManager();
        CashierManager cashier = new CashierManager();
        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");

        Scanner scanner = new Scanner(System.in);
        boolean openCF = true;

        while(openCF){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Minuto " + minute + " - ");
            client.clientArrival();
            System.out.println("En cola: " + client.size());

            if( cashier.findAvailableCashier() != null && client.size() > 0){
                cashier.assignItemCashier(client);
            }

            cashier.listCashiers();


            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            System.out.println("Clientes en cola: " + java.util.Arrays.toString(client.clientItems()));
            System.out.println("1. Siguiente minuto.");
            System.out.println("2. Finalizar programa.");
            System.out.println("3. Eliminar el primer cliente.");
            System.out.print("Seleccione una opcion: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    openCF = true;
                    break;
                case 2:
                    openCF = false;
                    break;
                case 3:
                    client.deleteClient();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            minute++;
        }
    }
}