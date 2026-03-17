package btth.notification;

public class EmailNotification implements NotificationService {

    public void send(String email, String message) {

        System.out.println("Đã gửi Email tới: " + email);
    }
}