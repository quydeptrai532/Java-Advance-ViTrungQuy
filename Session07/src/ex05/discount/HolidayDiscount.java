package ex05.discount;

public class HolidayDiscount implements DiscountStrategy {

    public double applyDiscount(double total) {
        return total * 0.15;
    }
}