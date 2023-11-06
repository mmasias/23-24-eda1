import cashier.CashierManager;
import client.ClientManager;

import java.util.Scanner;

public class CarreFour {

    private int minute = 1;
    private int minutesWithOutQueue = 0;
    private int totalClientServed = 0;
    private int openingTime = 9 * 60; // 9:00 am en minutos
    private int closingTime = 21 * 60; // 9:00 pm en minutos
    private boolean caja5Created = false;
    private int maxClientInQueue = 15;


    public boolean withinTheSchedule(){
        int minutesOpen = closingTime - openingTime;

        if(this.minute <= minutesOpen){
            return true;
        }

        return false;
    }


    public void start(){
        ClientManager queue = new ClientManager();
        CashierManager cashier = new CashierManager();
        cashier.createCashier("Caja1");
        cashier.createCashier("Caja2");
        cashier.createCashier("Caja3");
        cashier.createCashier("Caja4");

        Scanner scanner = new Scanner(System.in);

        while (this.withinTheSchedule()) {

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Minuto " + this.minute + " - ");

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
                queue.deleteFirstClientInQueue();
                this.totalClientServed++;
            }

            System.out.println("En cola: " + queue.size());

            if (queue.size() == 0){
                this.minutesWithOutQueue++;
            }

            if(queue.size() > this.maxClientInQueue && !caja5Created){
                cashier.createCashier("Caja5");
                this.caja5Created = true;
            }

            cashier.listCashiers();

            if(queue.size() <= this.maxClientInQueue && caja5Created && cashier.itemsFromLastCashier(4) == 0){
                cashier.deleteEndCashier();
                this.caja5Created = false;
            }


            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Enter siguiente minuto, 'q' para salir: ");

            String input = scanner.nextLine();
            if ("q".equals(input.toLowerCase())) {
                break;
            }

            this.minute++;
        }

        System.out.println("RESUMEN");
        System.out.println("============================================================");
        System.out.println("Minutos con cola en cero: " + this.minutesWithOutQueue);
        System.out.println("Personas en la cola al cierre: " + queue.size());
        System.out.println("Personas atendidas en el dia: " + this.totalClientServed);
        System.out.println("Articulos vendidos en el dia:" + cashier.totalItemsSold());
        System.out.println("============================================================");
    }

}
