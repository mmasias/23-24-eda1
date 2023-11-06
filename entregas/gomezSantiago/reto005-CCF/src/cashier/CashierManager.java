package cashier;
import client.ClientManager;
public class CashierManager {
    private CashierList cashiers;
    private boolean[] cashierStatus;

    public CashierManager(){
        this.cashiers = new CashierList();
        this.cashierStatus = new boolean[cashiers.size()];
    }

    public void createCashier (String cashierName){
        cashiers.addCashier(cashierName);
    }

    public String[] listCashiers(){
        return this.cashiers.getListCashiers();
    }

    public int size(){
        return this.cashiers.size();
    }

    public void assignItemCashier(ClientManager client) {

        String cashierName = cashiers.findAvailableCashier();

        for(int i = 0; i <= client.size(); i++){
            int itemsClient = client.clientItems()[i];

            System.out.println("DEBE DE PASARLE EL PRIMER ITEM: " + itemsClient);

            this.cashiers.setAssignItemCashier(cashierName, itemsClient);
            i++;
        }

        client.deleteClient();


       // this.cashiers.setAssignItemCashier(cashierName, shippingItems);
    }

    public String findAvailableCashier(){
        return this.cashiers.findAvailableCashier();
    }

    /*public void dispatchCustomer(int[] listClientItems, ClientManager client){
        System.out.println("Lista de CLIENTES listClientItems: " + java.util.Arrays.toString(listClientItems));

        String availableCashierName = cashiers.findAvailableCashier();
        System.out.println("Available cashier name: " + availableCashierName);

        if (availableCashierName != null){
            for (int item : listClientItems){
                boolean assigned = cashiers.setForCashierData(availableCashierName, false, item);
                if (assigned != false){
                    client.deleteClient();
                }
            }
        }
    }

    public String findAvailableCashier(){
        return this.cashiers.findAvailableCashier();
    }

    public boolean hasAvailableCashier() {
        return this.cashiers.findAvailableCashier() != null;
    }*/

}
