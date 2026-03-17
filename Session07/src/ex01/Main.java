package ex01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tạo sản phẩm: SP01 - Laptop - 15000000, SP02 - Chuột - 300000");
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuot", 300000);
        List<Product> products = new ArrayList<>();
        System.out.println("Đã thêm sản phẩm SP01, SP02");
        System.out.println("\nTạo khách hàng: Nguyễn Văn A - a@example.com");
        Customer customer = new Customer(
                "Nguyen Van A",
                "a@example.com",
                "HaNoiVietNam"
        );
        System.out.println("Đã thêm khách hàng");
        products.add(p1);
        products.add(p2);
        products.add(p2);
        System.out.println("\nTạo đơn hàng: SP01 (1 cái), SP02 (2 cái)");
        Order order = new Order("ORD001", customer, products);
        System.out.println("Đơn hàng ORD001 được tạo");
        System.out.println("\nTính tổng tiền");
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.caculator(order);
        System.out.println("Tổng tiền: " + total);
        System.out.println("\nLưu đơn hàng");
        OrderRepository repository = new OrderRepository();
        repository.saveOder(order);
        System.out.println("Đã lưu đơn hàng ORD001");
        System.out.println("\nGửi email xác nhận");
        EmailService emailService = new EmailService();
        emailService.senDingEmail(order,customer);
        System.out.println("Đã gửi email đến a@example.com: Đơn hàng ORD001 đã được tạo");
    }
}