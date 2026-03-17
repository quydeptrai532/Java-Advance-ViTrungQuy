package ex03;

public class MomoPayment implements EWalletPayable {

    @Override
    public void pay(double money) {
        payByWallet(money);
    }

    @Override
    public void payByWallet(double money) {
        System.out.println("Xu ly thanh toan MoMo: " + money + " - Thanh cong");
    }
}