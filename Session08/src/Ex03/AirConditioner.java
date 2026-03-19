package Ex03;

public class AirConditioner {
    private int temp = 25;

    public void setTemperature(int t) {
        this.temp = t;
        System.out.println("Điều hòa: Nhiệt độ = " + t);
    }

    public int getTemperature() {
        return temp;
    }
}
