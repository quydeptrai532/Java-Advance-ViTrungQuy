package ex06.discount;

public class FirstTimeDiscount implements DiscountStrategy {

    public double applyDiscount(double total) {
        System.out.println("Áp dụng giảm giá 15% cho lần đầu");
        return total * 0.15;
    }
}