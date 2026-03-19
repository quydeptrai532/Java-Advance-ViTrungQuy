package Ex03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Chọn nút: ");
                    int slot = sc.nextInt();

                    System.out.println("1.Light ON 2.Light OFF 3.Fan ON 4.Fan OFF 5.AC set temp");
                    int type = sc.nextInt();

                    Command cmd = null;

                    if (type == 1) cmd = new LightOnCommand(light);
                    else if (type == 2) cmd = new LightOffCommand(light);
                    else if (type == 3) cmd = new FanOnCommand(fan);
                    else if (type == 4) cmd = new FanOffCommand(fan);
                    else if (type == 5) {
                        System.out.print("Nhập nhiệt độ: ");
                        int t = sc.nextInt();
                        cmd = new ACSetTemperatureCommand(ac, t);
                    }

                    if (cmd != null) {
                        remote.setCommand(slot, cmd);
                    }
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 0:
                    return;
            }
        }
    }
}