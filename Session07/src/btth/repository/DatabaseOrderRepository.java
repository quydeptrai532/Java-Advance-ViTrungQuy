package btth.repository;

import btth.model.Order;

public class DatabaseOrderRepository implements OrderRepository {

    @Override
    public void save(Order order) {
        System.out.println("Đã lưu đơn hàng vào DB.");
    }
}