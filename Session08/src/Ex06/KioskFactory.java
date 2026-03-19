package Ex06;

public class KioskFactory extends SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new KioskDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CashPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new VoiceNotification();
    }
}
