import java.util.List;

public class Customer {
    private String name;
    private int age;
    private String paymentMethod;

    public Customer(String name, int age, List<String> productsToCheckout, String paymentMethod) {
        this.name = name;
        this.age = age;
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
