package ex06.notification;

public class PushNotification implements NotificationService {

    public void send(String message) {

        System.out.println(
                "Gửi push notification: Đơn hàng thành công"
        );
    }
}