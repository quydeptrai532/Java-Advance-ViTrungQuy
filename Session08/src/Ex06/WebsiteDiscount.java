package Ex06;

public class WebsiteDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.1;
        System.out.println("Áp dụng giảm giá 10%: " + formatNumber(discount));
        return price - discount;
    }

    @Override
    public String getDiscountName() {
        return "WebsiteDiscount";
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
