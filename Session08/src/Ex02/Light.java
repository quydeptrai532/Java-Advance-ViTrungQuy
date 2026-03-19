package Ex02;

public class Light {
    private boolean isOn;

    public Light() {
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("FACADE: Bật đèn");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("FACADE: Tắt đèn");
    }

    public boolean isOn() {
        return isOn;
    }
}
