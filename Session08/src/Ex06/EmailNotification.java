package Ex06;

public class EmailNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Gửi email: " + message);
    }
}
