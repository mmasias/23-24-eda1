package cashier;
public class CashierManager {
    private CashierList cashiers;

    public CashierManager(){
        this.cashiers = new CashierList();
    }

    public void createCashier (String cashierName){
        cashiers.addCashier(cashierName);
    }

    public String[] listCashiers(){
        return this.cashiers.getListCashiers();
    }

    public int size() {
        return this.cashiers.size();
    }

    public boolean freeCashier(){
        return this.cashiers.getFreeCashier();
    }

    public void serveClient(int item){
        cashiers.setServeClient(item);
    }

}
