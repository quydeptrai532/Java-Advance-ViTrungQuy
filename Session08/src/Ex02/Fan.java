package Ex02;

public class Fan {
    private int speed;

    public Fan() {
        this.speed = 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        if (speed == 0) {
            System.out.println("FACADE: Tắt quạt");
        } else if (speed == 1) {
            System.out.println("FACADE: Quạt chạy tốc độ thấp");
        } else if (speed == 2) {
            System.out.println("FACADE: Quạt chạy tốc độ trung bình");
        } else if (speed == 3) {
            System.out.println("FACADE: Quạt chạy tốc độ cao");
        }
    }

    public int getSpeed() {
        return speed;
    }
}
