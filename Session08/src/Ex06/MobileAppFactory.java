package Ex06;

public class MobileAppFactory extends SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}
