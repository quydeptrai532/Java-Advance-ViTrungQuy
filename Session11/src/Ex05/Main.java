package Ex05;

import Ex05.bussiness.DoctorService;
import Ex05.entity.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorService doctorService = new DoctorService();
        int choice;

        do {
            System.out.println("\n===== DOCTOR MANAGEMENT =====");
            System.out.println("1. Xem danh sach bac si");
            System.out.println("2. Them bac si moi");
            System.out.println("3. Thong ke chuyen khoa");
            System.out.println("4. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    ArrayList<Doctor> list=doctorService.getAllDoctor();
                    for (Doctor doc:list){
                        System.out.println(doc);
                    }
                    break;
                case 2:
                    Doctor newDoc=new Doctor();
                    System.out.println("Moi ban nhap vao id cua bac si moi");
                    newDoc.setId(Integer.parseInt(sc.nextLine()));
                    System.out.println("Moi ban nhap vao ten cua bac si moi");
                    newDoc.setName(sc.nextLine());
                    System.out.println("Moi ban nhap chuyen khao cua bac si moi");
                    newDoc.setSpecialty(sc.nextLine());
                    boolean result= doctorService.addDoctor(newDoc);
                    if(result) System.out.println(" them thanh cong");
                    else System.out.println(" them that bai");
                    break;
                case 3:
                    System.out.println("===== THONG KE CHUYEN KHOA =====");
                    doctorService.countSpecial();
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon ko co trong he thong");
            }


        } while (choice != 4);

        sc.close();
    }
}