package Ex05;

public class AirConditioner implements Observer {
    private int temp = 25;

    public void setTemperature(int t) {
        temp = t;
        System.out.println("Điều hòa: Nhiệt độ = " + t);
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            System.out.println("Điều hòa: Vẫn giữ nhiệt độ = " + temp);
        }
    }
}