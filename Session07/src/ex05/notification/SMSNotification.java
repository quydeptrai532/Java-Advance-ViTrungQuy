package ex05.notification;

public class SMSNotification implements NotificationService {

    public void send(String message) {
        System.out.println("Đã gửi SMS xác nhận");
    }
}