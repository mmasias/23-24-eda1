package cashier;

public class CashierNode {
    private boolean available;
    private String CashierName;
    private CashierNode next;

    public CashierNode(String CashierName){
        setCashierName(CashierName);
        setAvailable(true);
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void setAvailable(boolean isAvailable){
        this.available = isAvailable;
    }

    public void setCashierName(String Name){
        this.CashierName = Name;
    }

    public String getCashierName(){
        return this.CashierName;
    }

    public CashierNode getNext() {
        return next;
    }

    public void setNext(CashierNode next) {
        this.next = next;
    }

}
