package btth.payment;

import btth.model.Order;

public class ZaloPayPayment implements PaymentStrategy {

    public void pay(Order order) {

        System.out.println(
                "Thanh toán qua ZaloPay."
        );
    }
}