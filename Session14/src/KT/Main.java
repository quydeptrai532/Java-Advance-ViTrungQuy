package KT;

import KT.dao.BankRepo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankRepo bank = new BankRepo();
        System.out.print("Nhap tai khoan gui: ");
        String from = sc.nextLine();
        System.out.print("Nhap tai khoan nhan: ");
        String to = sc.nextLine();
        System.out.print("Nhap so tien: ");
        double amount = sc.nextDouble();
        bank.transfer(from, to, amount);
        sc.close();
    }
}