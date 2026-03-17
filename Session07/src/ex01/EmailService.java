package ex01;

public class EmailService {
    void senDingEmail(Order order,Customer customer){
        System.out.println("Da  gui email toi: "+customer.email + "Dong hang"+ order.oderId +"Da duoc tao");
    }
}
