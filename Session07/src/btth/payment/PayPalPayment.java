package btth.payment;

import btth.model.Order;

public class PayPalPayment implements PaymentStrategy {

    public void pay(Order order) {

        System.out.println(
                "Đang mở cổng PayPal... Thanh toán PayPal."
        );
    }
}