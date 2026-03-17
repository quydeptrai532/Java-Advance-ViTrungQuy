package btth.payment;

import btth.model.Order;

public interface PaymentStrategy {

    void pay(Order order);
}