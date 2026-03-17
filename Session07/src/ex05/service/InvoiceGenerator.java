package ex05.service;

import ex05.model.Order;
import ex05.model.OrderItem;

public class InvoiceGenerator {

    public void printInvoice(Order order) {

        System.out.println("=== HÓA ĐƠN ===");

        System.out.println("Khách: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {

            System.out.println(
                    item.getProduct().getId() +
                            " - Số lượng: " + item.getQuantity() +
                            " - Đơn giá: " + item.getProduct().getPrice() +
                            " - Thành tiền: " + item.getTotal()
            );
        }

        System.out.println("Tổng tiền: " + order.getTotal());
    }
}