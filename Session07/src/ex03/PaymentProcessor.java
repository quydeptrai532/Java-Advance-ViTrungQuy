package ex03;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double money) {
        paymentMethod.pay(money);
    }
}