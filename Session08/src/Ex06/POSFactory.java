package Ex06;

public class POSFactory extends SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}
