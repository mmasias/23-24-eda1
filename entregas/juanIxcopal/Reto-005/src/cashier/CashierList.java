package cashier;

public class CashierList {
    private int size = 0;
    private CashierNode first = null;

    public int size(){
        return this.size;
    }

    public void addCashier(String cashierName){
        CashierNode newCashier = new CashierNode(cashierName, true, 0);

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

    public String[] getListCashiers(){
        String[] list = new String[this.size];
        CashierNode iterator = this.first;
        int count = 0;

        while (iterator != null){
            list[count] = iterator.getCashierName();
            if(iterator.getShipingItems() > 0){
                iterator.setShipingItems(iterator.getShipingItems() - 1);
            }
            if(iterator.getShipingItems() == 0){
                iterator.setAvailable(true);
            }
            System.out.print(iterator.getCashierName() + "[" + iterator.getShipingItems() +  "]   ||  " );
            count ++;
            iterator = iterator.getNext();
        }

        System.out.println();

        return list;
    }

    public boolean setAvailableForCashier(String cashierName, boolean available, int shipingItems){
        CashierNode iterator = this.first;

        while (iterator != null){
            if(iterator.getCashierName().equals(cashierName)){
                iterator.setAvailable(available);
                iterator.setShipingItems(shipingItems);
                return available;
            }
            iterator = iterator.getNext();
        }
        return available;
    }

    public String findAvailableCashier() {
        CashierNode iterator = this.first;

        while (iterator != null) {
            if (iterator.getAvailable()) {
                return iterator.getCashierName();
            }
            iterator = iterator.getNext();
        }

        return null; // Si no hay cajas disponibles
    }


}