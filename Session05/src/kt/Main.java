package kt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    //Method in Menu
    static void displayMenu() {
        System.out.println("========== Product Management System =============");
        System.out.println("1. Them san pham moi");
        System.out.println("2. Hien thi danh sach san pham");
        System.out.println("3. Cap nhat so luong theo id");
        System.out.println("4. Xoa san pham het hang");
        System.out.println("5. Thoat chuong trinh");
    }
    //Method in ra san pham
    static void printProduct(List<Product> list){
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            System.out.println("Danh sach san pham:");
            list.forEach(System.out::println);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        while (true) {
            displayMenu();
            System.out.println("Moi ban nhap vao lua chon");
            int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhap id san pham:");
                        int id = sc.nextInt();

                        boolean exist = list.stream()
                                .anyMatch(p -> p.getId() == id);
                        if (exist) {
                            throw new InvalidProductExeption("ID da ton tai");
                        }
                        sc.nextLine();
                        System.out.println("Nhap ten san pham:");
                        String name = sc.nextLine();
                        if (name == null || name.isBlank()) {
                            throw new InvalidProductExeption("Ten khong hop le");
                        }
                        System.out.println("Nhap gia:");
                        double price = sc.nextDouble();
                        System.out.println("Nhap so luong:");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Nhap category:");
                        String category = sc.nextLine();
                        Product newProduct = new Product(id, name, price, quantity, category);
                        list.add(newProduct);
                        System.out.println("Them san pham thanh cong");
                        break;
                    case 2:
                        printProduct(list);
                        break;
                    case 3:
                        System.out.println("Nhap id can cap nhat:");
                        int updateId = sc.nextInt();
                        Optional<Product> optionalProduct = list.stream()
                                .filter(p -> p.getId() == updateId)
                                .findFirst();
                        Product product = optionalProduct.orElseThrow(() ->
                                new InvalidProductExeption("Khong tim thay san pham"));
                        System.out.println("Nhap so luong moi:");
                        int newQuantity = sc.nextInt();
                        if(newQuantity <0){
                            throw new InvalidProductExeption("So luong nhap vao khong hop le");
                        }
                        product.setQuantity(newQuantity);
                        System.out.println("Cap nhat thanh cong");
                        printProduct(list);
                        break;

                    case 4:
                        int before = list.size();
                        list.removeIf(p -> p.getQuantity() == 0);
                        int after = list.size();
                        if (before == after) {
                            System.out.println("Khong co san pham het hang");
                        } else {
                            System.out.println("Da xoa san pham het hang");
                            printProduct(list);
                        }

                        break;
                    case 5:
                        System.out.println("Thoat chuong trinh");
                        return;

                    default:
                        System.out.println("Lua chon khong hop le");
                }



        }
    }
}