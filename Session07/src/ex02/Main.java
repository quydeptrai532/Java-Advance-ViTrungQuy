package ex02;

public class Main {

    public static void main(String[] args) {

        double total = 1000000;

        System.out.println("Đơn hàng: tổng tiền 1.000.000, áp dụng PercentageDiscount 10%");
        OrderCalculator cal1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("Số tiền sau giảm: " + cal1.calculate(total));

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng FixedDiscount 50.000");
        OrderCalculator cal2 = new OrderCalculator(new FixedDiscount(50000));
        System.out.println("Số tiền sau giảm: " + cal2.calculate(total));

        System.out.println("\nĐơn hàng: tổng tiền 1.000.000, áp dụng NoDiscount");
        OrderCalculator cal3 = new OrderCalculator(new NoDiscount());
        System.out.println("Số tiền sau giảm: " + cal3.calculate(total));

        System.out.println("\nThêm HolidayDiscount 15% (không sửa code cũ)");
        OrderCalculator cal4 = new OrderCalculator(new HolidayDiscount());
        System.out.println("Số tiền sau giảm: " + cal4.calculate(total));
    }
}