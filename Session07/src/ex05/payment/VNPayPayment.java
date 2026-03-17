package ex05.payment;

public class VNPayPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán VNPay: " + amount);
    }
}