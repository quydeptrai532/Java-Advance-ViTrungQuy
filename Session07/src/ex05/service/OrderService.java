package ex05.service;

import ex05.model.Order;
import ex05.repository.OrderRepository;
import ex05.notification.NotificationService;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order) {

        repository.save(order);

        notification.send("Đơn hàng " + order.getId());
    }
}