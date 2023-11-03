package cashier;

public class CashierManager {
    CashierList cashiers = new CashierList();


    public void createCashier(String name){
        cashiers.createCashier(name);
    }

    public String[] listCashiers(){
        return cashiers.listCashiers();
    }
}
