package ex06;

import java.util.Scanner;
import ex06.factory.*;
import ex06.discount.*;
import ex06.payment.*;
import ex06.notification.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh bán:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");

        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        if(choice == 1){

            factory = new WebsiteFactory();
            System.out.println("Bạn đã chọn kênh Website");

        } else if(choice == 2){

            factory = new MobileAppFactory();
            System.out.println("Bạn đã chọn kênh Mobile App");

        } else {

            factory = new POSFactory();
            System.out.println("Bạn đã chọn kênh POS");
        }

        DiscountStrategy discount = factory.createDiscount();
        PaymentMethod payment = factory.createPayment();
        NotificationService notification = factory.createNotification();

        double total = 15000000;

        double discountAmount = discount.applyDiscount(total);

        double finalAmount = total - discountAmount;

        payment.pay(finalAmount);

        notification.send("Order success");
    }
}