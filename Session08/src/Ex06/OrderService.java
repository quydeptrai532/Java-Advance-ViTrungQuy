package Ex06;

public class OrderService {
    private SalesChannelFactory factory;
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.factory = factory;
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(String productName, double price, int quantity) {
        double totalPrice = price * quantity;
        double discountedPrice = discount.applyDiscount(totalPrice);
        payment.pay(discountedPrice);
        notification.notify("Đơn hàng thành công");
    }
}
