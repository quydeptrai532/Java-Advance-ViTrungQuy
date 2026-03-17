package btth;

import btth.model.Order;
import btth.repository.*;
import btth.payment.*;
import btth.notification.*;
import btth.service.*;

public class Main {

    public static void main(String[] args) {

        Order order = new Order("customer@gmail.com");

        OrderRepository repo = new DatabaseOrderRepository();

        PaymentStrategy payment = new CreditCardPayment();

        NotificationService notify = new EmailNotification();

        OrderProcessor processor =
                new OrderProcessor(repo, payment, notify);

        processor.processOrder(order);
    }
}