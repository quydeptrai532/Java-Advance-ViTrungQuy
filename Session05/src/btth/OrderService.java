package btth;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }

    public double calculateRevenue(){

        return orders.stream()
                .mapToDouble(Order::calculateTotal)
                .sum();
    }

}