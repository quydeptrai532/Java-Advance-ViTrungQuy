package Ex06;

public class VoiceNotification implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Thông báo âm thanh: " + message);
    }
}
