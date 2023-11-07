import java.util.ArrayList;
import java.util.List;

public class CCCF {
    public static void main(String[] args) throws Exception {

        int elapsedTime = 12 * 60, minutesWithoutCustomers = 0, attendedCustomers = 0, itemsSold = 0;
        int extraCheckoutOpenTime = 15;

        Queue queue = new Queue();

        List<Checkout> checkouts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            checkouts.add(new Checkout());
        }

        for (int minute = 1; minute <= elapsedTime; minute++) {
            System.out.print("Minute: " + minute + " -");

            // Customer arrival
            double newCustomerProbability = Math.random();
            if (newCustomerProbability < 0.4) {
                System.out.print(" A customer arrives -");
                Customer newCustomer = new Customer(null, minute, null, null);
                queue.addCustomer(newCustomer);
            } else {
                System.out.print(" No one arrives -");
                minutesWithoutCustomers++;
            }

            // Checkout customers
            for (Checkout checkout : checkouts) {
                if (checkout.isOpen() && checkout.isAvailable() && !queue.isEmpty()) {
                    Customer customer = queue.removeCustomer();
                    checkout.startProcessing((int) (Math.random() * ((10 - 5) + 1)) + 5);
                    attendedCustomers++;
                    itemsSold++;
                }
                checkout.processCustomer();
            }

            // Extra checkout
            if (extraCheckoutOpenTime > 0 && !queue.isEmpty()) {
                extraCheckoutOpenTime--;
                Customer customer = queue.removeCustomer();
                attendedCustomers++;
                itemsSold++;
            }

            // Checkout Display
            System.out.println(" In Queue: " + queue.size());
            for (int i = 0; i < checkouts.size(); i++) {
                System.out.print(" Checkout " + (i + 1) + " [" + (checkouts.get(i).isAvailable() ? "Available" : "Busy") + "] |");
            }
            System.out.println(" Extra Checkout [" + (extraCheckoutOpenTime > 0 ? "Open" : "Closed") + "]");
            System.out.println(
                    "..................................................................................................");
        }

        // Summary Display
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                 Summary of the day                 ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println(" Minutes with empty queue: " + minutesWithoutCustomers);
        System.out.println(" Customers in queue at closing: " + queue.size());
        System.out.println(" Served Customers: " + attendedCustomers);
        System.out.println(" Items sold during the day: " + itemsSold);
        System.out.println("════════════════════════════════════════════════════");
    }
}