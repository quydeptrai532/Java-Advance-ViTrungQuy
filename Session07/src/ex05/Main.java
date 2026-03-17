package ex05;

import java.util.*;
import ex05.model.*;
import ex05.payment.*;
import ex05.discount.*;
import ex05.repository.*;
import ex05.notification.*;
import ex05.service.*;

public class Main {

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();
        OrderService orderService = new OrderService(repo, notify);

        while(true){

            System.out.println("\n1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("5. Tổng doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){

                System.out.print("Mã: ");
                String id = sc.nextLine();

                System.out.print("Tên: ");
                String name = sc.nextLine();

                System.out.print("Giá: ");
                double price = sc.nextDouble();
                sc.nextLine();

                System.out.print("Danh mục: ");
                String cate = sc.nextLine();

                products.add(new Product(id,name,price,cate));

                System.out.println("Đã thêm sản phẩm " + id);
            }

            else if(choice == 2){

                System.out.print("Tên: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("ĐT: ");
                String phone = sc.nextLine();

                customers.add(new Customer(name,email,phone));

                System.out.println("Đã thêm khách hàng");
            }

            else if(choice == 0){
                break;
            }
        }
    }
}