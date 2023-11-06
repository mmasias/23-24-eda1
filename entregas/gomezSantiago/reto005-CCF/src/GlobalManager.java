import cashier.CashierManager;
import client.ClientManager;

import java.util.Scanner;

public class GlobalManager {
    public static void main(String[] args) {
        int minute = 1;
        ClientManager queue = new ClientManager();
        CashierManager cashier = new CashierManager();
        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");

        Scanner scanner = new Scanner(System.in);
        boolean openCF = true;

        while (openCF) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Minuto " + minute + " - ");

            double customerArrivalProbability = Math.random() * 100;
            if (customerArrivalProbability <= 60) {
                int randomItems = (int) Math.floor(Math.random() * (15 - 5 + 1) + 5);
                queue.addClientInQueue(randomItems);
                System.out.print("Llega 1 persona - ");
            } else {
                System.out.print("No llega nadie - ");
            }

            if(cashier.freeCashier() && queue.isEmpty()){
                cashier.serveClient(queue.firstItem());

                queue.deleteClientInQueue();
            }

            System.out.println("En cola: [ " + queue.size() + " ]");

            cashier.listCashiers();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

            System.out.println("1. Siguiente minuto.");
            System.out.println("2. Finalizar programa.");
            System.out.print("Seleccione una opcion: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    openCF = true;
                    break;
                case 2:
                    openCF = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            minute++;
        }
    }
}