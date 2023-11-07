import java.util.ArrayList;
import java.util.List;

class Queue {
    private List<Customer> customers;

    public Queue() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean isEmpty() {
        return customers.isEmpty();
    }

    public Customer removeCustomer() {
        if (!isEmpty()) {
            return customers.remove(0);
        }
        return null;
    }

    public int size() {
        return customers.size();
    }
}