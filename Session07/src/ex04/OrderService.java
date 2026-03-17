package ex04;

public class OrderService {

    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository,
                        NotificationService notificationService) {

        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(String id) {

        Order order = new Order(id);

        orderRepository.save(order);

        notificationService.send(
                "Don hang " + id + " da duoc tao",
                "customer"
        );
    }
}