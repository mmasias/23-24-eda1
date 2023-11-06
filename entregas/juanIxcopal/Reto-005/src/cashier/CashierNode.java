package cashier;

public class CashierNode {
    private boolean available;
    private String cashierName;
    private int shippingItems = 0;

    private CashierNode next;

    public CashierNode(String cashierName, boolean available, int shippingItems) {
        setCashierName(cashierName);
        setAvailable(available);
        setShippingItems(shippingItems);
    }

    public boolean getAvailable() {
        return this.available;
    }

    public String getCashierName() {
        return this.cashierName;
    }
    public int getShippingItems() {
        return this.shippingItems;
    }

    public CashierNode getNext(){
        return this.next;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }
    public void setCashierName(String cashierName){
        this.cashierName = cashierName;
    }
    public void setShippingItems(int shippingItems){
        this.shippingItems = shippingItems;
    }

    public void setNext(CashierNode next){
        this.next = next;
    }
}
