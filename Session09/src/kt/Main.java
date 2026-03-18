package kt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n----- QUẢN LÝ SẢN PHẨM -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Loại (1-Physical, 2-Digital): ");
                    int type = sc.nextInt(); sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price = sc.nextDouble();

                    System.out.print(type == 1 ? "Weight: " : "Size (MB): ");
                    double extra = sc.nextDouble();

                    Product p = ProductFactory.createProduct(type, id, name, price, extra);
                    db.addProduct(p);
                    break;

                case 2:
                    for (Product prod : db.getAll()) {
                        prod.displayInfo();
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    String updateId = sc.nextLine();

                    Product found = db.findById(updateId);
                    if (found != null) {
                        System.out.print("Tên mới: ");
                        found.setName(sc.nextLine());

                        System.out.print("Giá mới: ");
                        found.setPrice(sc.nextDouble());
                        sc.nextLine();
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID cần xóa: ");
                    String delId = sc.nextLine();
                    db.deleteProduct(delId);
                    break;

                case 5:
                    System.out.println("Thoát");
                    return;

                default:
                    System.out.println("Lựa chọn sai vui lòng chọn lại");
            }
        }
    }
}