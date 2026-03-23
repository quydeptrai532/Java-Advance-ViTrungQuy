package Ex06;

import Ex06.dao.HospitalDAO;
import Ex06.entity.Medicine;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalDAO hospitalDAO = new HospitalDAO();

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Cap nhat ton kho thuoc");
            System.out.println("2. Tim thuoc theo khoang gia");
            System.out.println("3. Tinh tong tien don thuoc");
            System.out.println("4. Thong ke doanh thu theo ngay");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID thuoc: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhap so luong can them: ");
                    int addedQuantity = Integer.parseInt(sc.nextLine());

                    boolean result = hospitalDAO.updateMedicineStock(id, addedQuantity);
                    if (result) {
                        System.out.println("Cap nhat ton kho thanh cong.");
                    } else {
                        System.out.println("Cap nhat ton kho that bai.");
                    }
                    break;

                case 2:
                    System.out.print("Nhap gia thap nhat: ");
                    double minPrice = Double.parseDouble(sc.nextLine());

                    System.out.print("Nhap gia cao nhat: ");
                    double maxPrice = Double.parseDouble(sc.nextLine());

                    List<Medicine> medicines = hospitalDAO.findMedicinesByPriceRange(minPrice, maxPrice);
                    hospitalDAO.displayMedicines(medicines);
                    break;

                case 3:
                    System.out.print("Nhap ID don thuoc: ");
                    int prescriptionId = Integer.parseInt(sc.nextLine());

                    double total = hospitalDAO.calculatePrescriptionTotal(prescriptionId);
                    System.out.println("Tong tien don thuoc = " + total);
                    break;

                case 4:
                    System.out.print("Nhap ngay can thong ke (yyyy-MM-dd): ");
                    String dateInput = sc.nextLine();

                    Date saleDate = Date.valueOf(dateInput);
                    double revenue = hospitalDAO.getDailyRevenue(saleDate);

                    System.out.println("Doanh thu ngay " + saleDate + " = " + revenue);
                    break;

                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (true);
    }
}