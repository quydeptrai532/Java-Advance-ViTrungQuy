package ex01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Moi ban nhap nam sinh ");
            int age=Integer.parseInt(sc.nextLine());
            System.out.println("Tuoi cua ban la:"+(2026-age));
        }
        catch (NumberFormatException e){
            System.out.println("Tuoi ban nhap sai dinh dang");
        }
        finally {
            System.out.println("Don dep tai nguyen");
            sc.close();
        }
    }
}
