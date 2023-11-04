package cashier;

import java.util.List;

import client.ClientManager;

public class CashierManager {
    CashierList cashiers = new CashierList();

    public void createCashier(String name){
        cashiers.createCashier(name);
    }

    public String[] listCashiers(){
        return cashiers.listCashiers();
    }

    public List<String> listAvailableCashiers(){
        return cashiers.listAvailableCashiers();
    }


    // Metodos nuevos
    public void atenderCliente(List<Integer> listClients){

        System.out.println("RECIBE LISTA DE CLIENTES PARA ATENDER");
        System.out.println(listClients);
    }

    public void proccessClient(int numberClient, int items, ClientManager clientManager){
        List<String> availableCashiers = listAvailableCashiers();

        if(!availableCashiers.isEmpty()){
            String cashierName = availableCashiers.get(0); // Tomar la primera caja disponible
            cashiers.markCashierAsBusy(cashierName); // Marcar la caja como ocupada
            System.out.println("Cliente " + numberClient + " asignado a " + cashierName);
            System.out.println("Procesando items...");

            while (items > 0) {
                System.out.println("Item " + (items - 1) + " procesado.");
                items--;
            }

            cashiers.markCashierAsAvailable(cashierName); // Liberar la caja una vez que se haya atendido al cliente
            clientManager.clientAttended(numberClient); // Eliminar al cliente de la cola

        }

        System.out.println("||--------------------------||");
        System.out.println(numberClient);
        System.out.println(items);
        System.out.println(clientManager);
        System.out.println("||--------------------------||");
    }




}
