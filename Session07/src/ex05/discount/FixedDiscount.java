package ex05.discount;

public class FixedDiscount implements DiscountStrategy {

    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    public double applyDiscount(double total) {
        return amount;
    }
}