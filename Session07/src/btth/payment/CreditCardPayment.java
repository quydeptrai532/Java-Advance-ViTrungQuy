package btth.payment;

import btth.model.Order;

public class CreditCardPayment implements PaymentStrategy {

    public void pay(Order order) {

        System.out.println(
                "Đang kết nối API Ngân hàng... Thanh toán Thẻ tín dụng."
        );
    }
}