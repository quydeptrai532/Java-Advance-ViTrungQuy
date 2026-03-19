package Ex06;

public class PushNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
