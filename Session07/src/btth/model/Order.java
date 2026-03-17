package btth.model;

public class Order {

    private String customerEmail;

    public Order(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}