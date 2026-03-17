package ex03;

public interface CardPayable extends PaymentMethod {
    void payByCard(double money);
}