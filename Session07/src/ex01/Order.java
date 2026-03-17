package ex01;

import java.util.List;

public class Order {
    String oderId;
    Customer customer;
    List<Product> products;
    double total;

    public Order(String oderId, Customer customer, List<Product> products) {
        this.oderId = oderId;
        this.customer = customer;
        this.products = products;
    }

    public Order() {
    }

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
