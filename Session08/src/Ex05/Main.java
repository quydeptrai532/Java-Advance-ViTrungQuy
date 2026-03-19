package Ex05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        Command lightOff = new LightOffCommand(light);
        Command acSet = new ACSetTempCommand(ac, 28);
        Command fanLow = new FanLowCommand(fan);

        List<Command> list = Arrays.asList(lightOff, acSet, fanLow);
        Command sleepMode = new SleepModeCommand(list);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Bật chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int t = sc.nextInt();
                    sensor.setTemperature(t);
                    break;

                case 0:
                    return;
            }
        }
    }
}