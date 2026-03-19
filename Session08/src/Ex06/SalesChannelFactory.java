package Ex06;

public abstract class SalesChannelFactory {
    public abstract DiscountStrategy createDiscountStrategy();
    public abstract PaymentMethod createPaymentMethod();
    public abstract NotificationService createNotificationService();
}
