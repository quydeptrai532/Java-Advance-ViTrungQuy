package ex01;

public class OrderRepository {
    Product findOder(Order oder, String findId) {
        return oder.products.stream()
                .filter(product -> product.productId.equals(findId))
                .findFirst()
                .orElse(null);
    }
    void saveOder(Order order){
        System.out.println("Da luu don hang :"+order.oderId);
    }

}
