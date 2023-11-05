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
        String availableCashierName = cashiers.findAvailableCashier();

        if (availableCashierName != null) {
            for (int item : listClientItems) {
                boolean assigned = cashiers.setForCashierData(availableCashierName, false, item);

                if (assigned != true)  {
                    client.deleteClient();
                } else {
                    break;
                }

            }
        }
    }

    public String findAvailableCashier() {
        return this.cashiers.findAvailableCashier();
    }

    public boolean hasAvailableCashier() {
        return this.cashiers.findAvailableCashier() != null;
    }
}