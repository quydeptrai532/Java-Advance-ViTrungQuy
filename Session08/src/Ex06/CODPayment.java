package Ex06;

public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán COD: " + formatNumber(amount));
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
