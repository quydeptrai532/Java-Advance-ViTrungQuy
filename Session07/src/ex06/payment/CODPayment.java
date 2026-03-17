package ex06.payment;

public class CODPayment implements PaymentMethod {

    public void pay(double amount) {

        System.out.println("Thanh toán tiền mặt tại POS");
    }
}