package Ex02;

public class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private TemperatureSensor temperatureSensor;

    public SmartHomeFacade(Light light, Fan fan, AirConditioner airConditioner, TemperatureSensor temperatureSensor) {
        this.light = light;
        this.fan = fan;
        this.airConditioner = airConditioner;
        this.temperatureSensor = temperatureSensor;
    }

    public void leaveHome() {
        System.out.println("=== CHẾ ĐỘ RỜI NHÀ ===");
        light.turnOff();
        fan.setSpeed(0);
        airConditioner.turnOff();
        System.out.println();
    }

    public void sleepMode() {
        System.out.println("=== CHẾ ĐỘ NGỦ ===");
        light.turnOff();
        airConditioner.setTemperature(28);
        fan.setSpeed(1);
        System.out.println();
    }

    public double getCurrentTemperature() {
        return temperatureSensor.getTemperatureCelsius();
    }
}
