package btth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MenuRepository menuRepo = new MenuRepository();
        OrderService orderService = new OrderService();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("1. Add Food");
            System.out.println("2. Show Menu");
            System.out.println("3. Create Order");
            System.out.println("4. Revenue");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    menuRepo.add(new Food(id,name,price));
                    break;

                case 2:

                    menuRepo.showAll();
                    break;

                case 3:

                    Order order = new Order("ORD1");

                    menuRepo.showAll();

                    System.out.print("Enter ID food: ");
                    String fid = sc.nextLine();

                    MenuItem item = menuRepo.findById(fid).orElse(null);

                    if(item != null){

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        order.addItem(item,qty);
                        order.showItems();

                        System.out.println("Total: "+order.calculateTotal());

                        orderService.addOrder(order);

                    }

                    break;

                case 4:

                    System.out.println("Revenue: "+orderService.calculateRevenue());
                    break;

                case 0:

                    return;
            }

        }

    }
}