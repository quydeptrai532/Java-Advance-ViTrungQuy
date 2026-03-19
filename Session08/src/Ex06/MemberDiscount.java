package Ex06;

public class MemberDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        double discount = price * 0.05;
        System.out.println("Áp dụng giảm giá 5% (thành viên): " + formatNumber(discount));
        return price - discount;
    }

    @Override
    public String getDiscountName() {
        return "MemberDiscount";
    }

    private String formatNumber(double num) {
        return String.format("%.0f", num);
    }
}
