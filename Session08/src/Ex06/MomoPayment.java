package Ex06;

public class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + formatNumber(amount));
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
