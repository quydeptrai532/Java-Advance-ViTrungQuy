package Ex06;

public class FirstTimeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.15;
        System.out.println("Áp dụng giảm giá 15% (lần đầu): " + formatNumber(discount));
        return price - discount;
    }

    @Override
    public String getDiscountName() {
        return "FirstTimeDiscount";
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
