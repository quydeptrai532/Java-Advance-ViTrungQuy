package ex03;

public class CODPayment implements CODPayable {

    @Override
    public void pay(double money) {
        payCod(money);
    }

    @Override
    public void payCod(double money) {
        System.out.println("Xu ly thanh toan COD: " + money + " - Thanh cong");
    }
}