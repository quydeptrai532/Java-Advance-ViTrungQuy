package ex06.notification;

public class EmailNotification implements NotificationService {

    public void send(String message) {

        System.out.println("Gửi email xác nhận");
    }
}