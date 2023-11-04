package cashier;

public class CashierNode {
    private boolean available;
    private String CashierName;
    private int shipingItems = 0;
    private CashierNode next;

    public CashierNode(String CashierName, boolean available, int shipingItems){
        setCashierName(CashierName);
        setAvailable(available);
        setShipingItems(shipingItems);
    }

    //GETERS
    public boolean getAvailable(){
        return this.available;
    }

    public String getCashierName(){
        return this.CashierName;
    }

    public CashierNode getNext() {
        return next;
    }

    public int getShipingItems(){
        return this.shipingItems;
    }

    // SETERS
    public void setAvailable(boolean isAvailable){
        this.available = isAvailable;
    }

    public void setCashierName(String Name){
        this.CashierName = Name;
    }

    public void setNext(CashierNode next) {
        this.next = next;
    }

    public void setShipingItems(int shipingItems){
        this.shipingItems = shipingItems;
    }

}
