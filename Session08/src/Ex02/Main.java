package Ex02;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();

        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor temperatureSensor = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade smartHome = new SmartHomeFacade(light, fan, airConditioner, temperatureSensor);

        System.out.println("========================================");
        System.out.println("ỨNG DỤNG ADAPTER & FACADE");
        System.out.println("========================================\n");

        System.out.println("1. XEM NHIỆT ĐỘ HIỆN TẠI");
        double currentTemp = smartHome.getCurrentTemperature();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C (chuyển đổi từ %d°F)\n", currentTemp, oldThermometer.getTemperatureFahrenheit());
        System.out.println();

        System.out.println("2. KÍCH HOẠT CHẾ ĐỘ RỜI NHÀ");
        smartHome.leaveHome();

        System.out.println("3. KÍCH HOẠT CHẾ ĐỘ NGỦ");
        smartHome.sleepMode();
    }
}
