package ex05.repository;

import ex05.model.Order;
import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> findAll();
}