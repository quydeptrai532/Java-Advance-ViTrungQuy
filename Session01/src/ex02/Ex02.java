package ex02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Moi ban nhap so nguoi");
            int people=Integer.parseInt(sc.nextLine());
            System.out.println("Moi ban nhap so nhom muon chia");
            int group=Integer.parseInt(sc.nextLine());
            System.out.println("So nguoi moi~ nhon la:"+(people/group));

        }
        catch (ArithmeticException e){
            System.out.println("Khong the chia cho 0");

        }
        finally {
            System.out.println("Don dep tai nguyen");
            sc.close();
        }
    }
}
