package Ex05;

import Ex05.dao.PatientRepo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientRepo patientRepo = new PatientRepo();
        boolean isExit = false;

        do {
            System.out.println("========== MENU QUAN LY BENH NHAN ==========");
            System.out.println("1. Danh sach benh nhan");
            System.out.println("2. Tiep nhan benh nhan moi");
            System.out.println("3. Cap nhat benh an");
            System.out.println("4. Xuat vien va tinh phi");
            System.out.println("5. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le, vui long nhap so!");
                continue;
            }

            switch (choice) {
                case 1:
                    patientRepo.showAllPatients();
                break;

                case 2:
                    patientRepo.addPatient();
                    break;

                case 3:
                     System.out.print("Nhap ma benh nhan can cap nhat: ");
                     int idUpdate = Integer.parseInt(sc.nextLine());
                     patientRepo.updatePatient(idUpdate);
                    break;

                case 4:
                     System.out.print("Nhap ma benh nhan can xuat vien: ");
                     int idDischarge = Integer.parseInt(sc.nextLine());
                     System.out.println("Hoa don thanh toan : "+patientRepo.totalConsume(idDischarge));
                    break;

                case 5:
                    System.out.println("Da thoat chuong trinh!");
                    isExit = true;
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long nhap tu 1 den 5!");
            }

        } while (!isExit);
    }
}