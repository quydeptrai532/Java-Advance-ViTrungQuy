package btth.service;

import btth.model.Order;
import btth.repository.OrderRepository;
import btth.payment.PaymentStrategy;
import btth.notification.NotificationService;

public class OrderProcessor {

    private OrderRepository repository;
    private PaymentStrategy payment;
    private NotificationService notification;

    public OrderProcessor(OrderRepository repository,
                          PaymentStrategy payment,
                          NotificationService notification) {

        this.repository = repository;
        this.payment = payment;
        this.notification = notification;
    }

    public void processOrder(Order order) {

        repository.save(order);

        payment.pay(order);

        notification.send(
                order.getCustomerEmail(),
                "Đơn hàng của bạn đã được xử lý thành công!"
        );
    }
}