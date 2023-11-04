package cashier;

import client.ClientManager;

public class CashierManager {

    private CashierList cashiers;
    private boolean[] cashierStatus;

    public CashierManager(){
        this.cashiers = new CashierList();
        this.cashierStatus = new boolean[cashiers.size()];
    }

    public void createCashier(String cashierName){
        cashiers.addCashier(cashierName);
    }

    public String[] listCashiers(){
        return cashiers.getListCashiers();
    }

    public int size(){
        return cashiers.size();
    }

    public void dispatchCustomer(int[] listClientItems, ClientManager client){
        String availableCashier = cashiers.findAvailableCashier();

        /*if (availableCashier != null) {
            for (int item : listClientItems) {
                cashiers.setAvailableForCashier(availableCashier, false, item);
                client.deleteClient();
            }
        }*/
        if (availableCashier != null) {
            for (int item : listClientItems) {
                boolean assigned = cashiers.setAvailableForCashier(availableCashier, false, item);
                if (assigned) {
                    client.deleteClient();
                }
            }
        }
    }

    public String findAvailableCashier() {
        return cashiers.findAvailableCashier();
    }

    public boolean hasAvailableCashier() {
        return cashiers.findAvailableCashier() != null;
    }
}