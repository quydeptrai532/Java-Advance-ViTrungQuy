package ex06.factory;

import ex06.discount.DiscountStrategy;
import ex06.payment.PaymentMethod;
import ex06.notification.NotificationService;

public interface SalesChannelFactory {

    DiscountStrategy createDiscount();

    PaymentMethod createPayment();

    NotificationService createNotification();
}