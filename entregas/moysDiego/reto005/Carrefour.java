import java.util.LinkedList;
import java.util.Queue;

public class Carrefour{
    public static void main(String[] args) {
        int tiempoTotal = 1 * 60;
        int numberOfCheckouts = 4;
        Queue<Customer> customerQueue = new LinkedList<>();

        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {
            System.out.print("Minuto " + minuto);

            if (Math.random() <= 0.4) {
                Customer customer = new Customer();
                customerQueue.offer(customer);
                System.out.println(" - Ha llegado una persona con " + customer.getItemsInCart() + " items.");
            } else {
                System.out.println(" - No ha llegado nadie.");
            }

            System.out.println("> Personas en cola: " + customerQueue.size());

            Checkout[] checkouts = new Checkout[numberOfCheckouts];
            for (int i = 0; i < numberOfCheckouts; i++) {
                checkouts[i] = new Checkout();
            }

            for (int i = 0; i < numberOfCheckouts; i++) {
                if (!customerQueue.isEmpty() && checkouts[i].isAvailable()) {
                    Customer customer = customerQueue.poll();
                    checkouts[i].serveCustomer(customer);
                    System.out.println("  > Caja " + (i + 1) + " atiende a una persona con " + customer.getItemsInCart() + " items.");
                }
                checkouts[i].processItem();
            }
        }

        System.out.println("========================================");
        System.out.println("Cerrando el programa...");
    }
}
