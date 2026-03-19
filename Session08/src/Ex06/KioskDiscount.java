package Ex06;

public class KioskDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.08;
        System.out.println("Áp dụng giảm giá 8% (Kiosk): " + formatNumber(discount));
        return price - discount;
    }

    @Override
    public String getDiscountName() {
        return "KioskDiscount";
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
