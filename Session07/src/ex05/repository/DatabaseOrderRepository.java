package ex05.repository;

import ex05.model.Order;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào database: " + order.getId());
    }

    public List<Order> findAll() {
        return orders;
    }
}