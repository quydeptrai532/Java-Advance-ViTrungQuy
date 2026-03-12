package btth;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private String orderId;
    private Map<MenuItem, Integer> items = new HashMap<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addItem(MenuItem item, int quantity) {
        items.put(item, quantity);
    }

    public double calculateTotal() {

        double total = 0;

        for(Map.Entry<MenuItem,Integer> entry : items.entrySet()){

            MenuItem item = entry.getKey();
            int qty = entry.getValue();

            total += item.calculatePrice() * qty;
        }

        return total;
    }

    public void showItems(){

        for(Map.Entry<MenuItem,Integer> entry : items.entrySet()){
            System.out.println(entry.getKey().getName()+" x"+entry.getValue());
        }

    }
}