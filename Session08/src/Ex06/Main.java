package Ex06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== HỆ THỐNG BÁN HÀNG ĐA KÊNH ==========");
            System.out.println("1. Kênh Website");
            System.out.println("2. Kênh Mobile App");
            System.out.println("3. Kênh POS");
            System.out.println("4. Kênh Kiosk");
            System.out.println("0. Thoát");
            System.out.print("Chọn kênh bán hàng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Cảm ơn đã sử dụng!");
                break;
            }

            SalesChannelFactory factory = null;
            String channelName = "";

            switch (choice) {
                case 1:
                    factory = new WebsiteFactory();
                    channelName = "Website";
                    break;
                case 2:
                    factory = new MobileAppFactory();
                    channelName = "Mobile App";
                    break;
                case 3:
                    factory = new POSFactory();
                    channelName = "POS";
                    break;
                case 4:
                    factory = new KioskFactory();
                    channelName = "Kiosk";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }

            System.out.println("\nBạn đã chọn kênh " + channelName);

            System.out.print("Nhập tên sản phẩm: ");
            String productName = sc.nextLine();

            System.out.print("Nhập giá sản phẩm: ");
            double price = sc.nextDouble();

            System.out.print("Nhập số lượng: ");
            int quantity = sc.nextInt();

            OrderService service = new OrderService(factory);
            service.processOrder(productName, price, quantity);
        }

        sc.close();
    }
}
