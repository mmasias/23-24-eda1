package cashier;

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
            System.out.println(iterator.getCashierName() + "[" + iterator.getAvailable() +  "]" );
            count ++;
            iterator = iterator.getNext();
        }

        return list;
    }
}
