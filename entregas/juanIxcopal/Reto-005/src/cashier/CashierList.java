package cashier;
import java.util.List;
import java.util.ArrayList;
public class CashierList {

    private CashierNode first = null;

    private int size = 0;

    public int size() {
        return this.size;
    }

    public void createCashier(String cashierName){
        CashierNode newCashier = new CashierNode(cashierName);

        if (this.first == null) {
            this.first = newCashier ;
        } else {
            CashierNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newCashier);
        }
        this.size ++;
    }

    public String[] listCashiers(){
        String[] list = new String[this.size];
        CashierNode iterator = this.first;
        int count = 0;

        while (iterator != null){
            list[count] = iterator.getCashierName();
            System.out.print(iterator.getCashierName() + "[" + iterator.isAvailable() +  "]   ||  " );
            count ++;
            iterator = iterator.getNext();
        }

        System.out.println();

        return list;
    }


    //Nuevos metodos

    public List<String> listAvailableCashiers(){
        List<String> availableCashiers = new ArrayList<>();

        CashierNode iterator = this.first;

        while (iterator != null){
            if(iterator.isAvailable()){
                availableCashiers.add(iterator.getCashierName());
            }
            iterator = iterator.getNext();
        }
        return availableCashiers;
    }

    public void markCashierAsBusy(String cashierName) {
        CashierNode iterator = this.first;
        while (iterator != null) {
            if (iterator.getCashierName().equals(cashierName)) {
                iterator.setAvailable(false);
                break;
            }
            iterator = iterator.getNext();
        }
    }

    public void markCashierAsAvailable(String cashierName) {
        CashierNode iterator = this.first;
        while (iterator != null) {
            if (iterator.getCashierName().equals(cashierName)) {
                iterator.setAvailable(true);
                break;
            }
            iterator = iterator.getNext();
        }
    }
}
