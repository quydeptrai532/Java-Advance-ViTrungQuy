package ex06.factory;

import ex06.discount.*;
import ex06.payment.*;
import ex06.notification.*;

public class MobileAppFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new FirstTimeDiscount();
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}