package cashier;

import java.util.SplittableRandom;

public class CashierList {
    private int size = 0;
    private CashierNode first = null;

    public int size(){
        return this.size;
    }

    public void addCashier(String cashierName){
        CashierNode newCashier = new CashierNode(cashierName, true, 0);

        if (this.first == null){
            this.first = newCashier;
        } else {
            CashierNode iterator = this.first;
            while (iterator.getNext() != null){
                iterator = iterator.getNext();
            }
            iterator.setNext(newCashier);
        }
        this.size++;
    }

    public String[] getListCashiers(){
        String[] list = new String[this.size];
        CashierNode iterator = this.first;
        int count = 0;

        while (iterator != null){
            list[count] = iterator.getCashierName();
            if (iterator.getShippingItems() > 0){
                iterator.setShippingItems(iterator.getShippingItems() - 1);
            }
            if (iterator.getShippingItems() == 0) {
                iterator.setAvailable(true);
            }
            System.out.print(iterator.getCashierName() + "[" + iterator.getShippingItems() + "] [" + iterator.getAvailable() + "] | ");
            count++;
            iterator = iterator.getNext();
        }
        System.out.println();
        return list;
    }

    public void setAssignItemCashier(String cashierName, int shippingItems) {
        CashierNode iterator = this.first;

        while (iterator != null) {
            if (iterator.getCashierName().equals(cashierName) && iterator.getAvailable() != false) {
                iterator.setAvailable(false);
                iterator.setShippingItems(shippingItems);
                System.out.println("CAJA : " + iterator.getCashierName() + " Libre, aqui asignar item a esa caja");
            }
            iterator = iterator.getNext();
        }

        return;

    }

    public String findAvailableCashier(){
        CashierNode iterator = this.first;

        while (iterator != null){
            if (iterator.getAvailable()){
                return iterator.getCashierName();
            }
            iterator = iterator.getNext();
        }

        return null;
    }

    /*public boolean setForCashierData(String cashierName, boolean available, int shippingItems){
        CashierNode iterator = this.first;

        while (iterator != null){
            if(iterator.getCashierName().equals(cashierName)){
                iterator.setAvailable(available);
                iterator.setShippingItems(shippingItems);
                return iterator.getAvailable();
            }
            iterator = iterator.getNext();
        }
        return iterator.getAvailable();
    }

    public String findAvailableCashier(){
        CashierNode iterator = this.first;

        while (iterator != null){
            if (iterator.getAvailable()){
                return iterator.getCashierName();
            }
            iterator = iterator.getNext();
        }

        return null;
    }*/
}
