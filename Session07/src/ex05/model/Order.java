package ex05.model;

import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private double total;

    public Order(String id, Customer customer, List<OrderItem> items, double total) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    public String getId() { return id; }

    public Customer getCustomer() { return customer; }

    public List<OrderItem> getItems() { return items; }

    public double getTotal() { return total; }
}