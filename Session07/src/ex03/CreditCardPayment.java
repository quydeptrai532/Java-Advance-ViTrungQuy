package ex03;

public class CreditCardPayment implements CardPayable {

    @Override
    public void pay(double money) {
        payByCard(money);
    }

    @Override
    public void payByCard(double money) {
        System.out.println("Xu ly thanh toan the tin dung: " + money + " - Thanh cong");
    }
}