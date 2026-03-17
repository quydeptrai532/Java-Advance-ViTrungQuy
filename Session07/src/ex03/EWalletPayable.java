package ex03;

public interface EWalletPayable extends PaymentMethod {
    void payByWallet(double money);
}