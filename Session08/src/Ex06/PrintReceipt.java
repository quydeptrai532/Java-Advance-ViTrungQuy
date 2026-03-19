package Ex06;

public class PrintReceipt implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}
