package Ex02;

public class AirConditioner {
    private double temperature;
    private boolean isOn;

    public AirConditioner() {
        this.temperature = 25.0;
        this.isOn = false;
    }

    public void setTemperature(double temp) {
        this.temperature = temp;
        this.isOn = true;
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("FACADE: Tắt điều hòa");
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isOn() {
        return isOn;
    }
}
