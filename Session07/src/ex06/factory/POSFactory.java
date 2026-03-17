package ex06.factory;

import ex06.discount.*;
import ex06.payment.*;
import ex06.notification.*;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new MemberDiscount();
    }

    public PaymentMethod createPayment() {
        return new CODPayment();
    }

    public NotificationService createNotification() {
        return new PrintNotification();
    }
}