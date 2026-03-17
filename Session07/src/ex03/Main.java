package ex03;

public class Main {

    public static void main(String[] args) {

        // COD
        PaymentMethod cod = new CODPayment();
        PaymentProcessor processor1 = new PaymentProcessor(cod);
        processor1.processPayment(500000);

        // Credit Card
        PaymentMethod card = new CreditCardPayment();
        PaymentProcessor processor2 = new PaymentProcessor(card);
        processor2.processPayment(1000000);

        // MoMo
        PaymentMethod momo = new MomoPayment();
        PaymentProcessor processor3 = new PaymentProcessor(momo);
        processor3.processPayment(750000);

        // Test LSP
        System.out.println("Test LSP: thay CreditCardPayment bang MomoPayment");

        PaymentMethod test = new MomoPayment();
        PaymentProcessor processor4 = new PaymentProcessor(test);
        processor4.processPayment(1000000);
    }
}