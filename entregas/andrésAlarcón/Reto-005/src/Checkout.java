public class Checkout {
    private int processingTime;
    private boolean isOpen;

    public Checkout() {
        this.processingTime = 0;
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public void processCustomer() {
        if (processingTime > 0) {
            processingTime--;
        }
    }

    public boolean isAvailable() {
        return processingTime == 0;
    }

    public void startProcessing(int processingTime) {
        this.processingTime = processingTime;
    }
}
