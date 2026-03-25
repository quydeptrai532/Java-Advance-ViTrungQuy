package Ex05.controller;

import Ex05.dao.HospitalDAO;

import java.util.Scanner;

public class HospitalController {
    private HospitalDAO dao = new HospitalDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem giường trống");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("0. Thoát");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    dao.showEmptyBeds();
                    break;

                case "2":
                    handleInput();
                    break;

                case "0":
                    return;

                default:
                    System.out.println("Chọn sai");
            }
        }
    }

    private void handleInput() {
        try {
            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Mã giường: ");
            int bedId = Integer.parseInt(sc.nextLine());

            System.out.print("Tiền tạm ứng: ");
            double amount = Double.parseDouble(sc.nextLine());

            dao.tiepNhanBenhNhan(name, age, bedId, amount);

        } catch (Exception e) {
            System.out.println("Dữ liệu nhập không hợp lệ");
        }
    }
}