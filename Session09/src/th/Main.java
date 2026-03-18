package th;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// ================== ENUM ==================
enum LightColor {
    RED, YELLOW, GREEN
}

// ================== STATE PATTERN ==================
interface TrafficLightState {
    LightColor getColor();
}

class RedState implements TrafficLightState {
    public LightColor getColor() { return LightColor.RED; }
}

class YellowState implements TrafficLightState {
    public LightColor getColor() { return LightColor.YELLOW; }
}

class GreenState implements TrafficLightState {
    public LightColor getColor() { return LightColor.GREEN; }
}

// ================== OBSERVER ==================
interface Observer {
    void update(LightColor color);
}

// ================== TRAFFIC LIGHT ==================
class TrafficLight implements Runnable {
    private TrafficLightState state;
    private List<Observer> observers = new ArrayList<>();

    public TrafficLight() {
        state = new RedState();
    }

    public synchronized void attach(Observer o) {
        observers.add(o);
    }

    public synchronized void notifyObservers() {
        for (Observer o : observers) {
            o.update(state.getColor());
        }
    }

    public void changeState(TrafficLightState newState) {
        state = newState;
        System.out.println("🚦 Light: " + state.getColor());
        notifyObservers();
    }

    @Override
    public void run() {
        try {
            while (true) {
                changeState(new GreenState());
                Thread.sleep(3000);

                changeState(new YellowState());
                Thread.sleep(2000);

                changeState(new RedState());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ================== INTERSECTION ==================
class Intersection {
    private Lock lock = new ReentrantLock();

    public void enter(String vehicleName) {
        lock.lock();
        try {
            System.out.println("🚗 " + vehicleName + " is PASSING intersection...");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("✅ " + vehicleName + " EXITED intersection");
            lock.unlock();
        }
    }
}

// ================== VEHICLE ==================
abstract class Vehicle implements Runnable, Observer {
    protected String name;
    protected int speed;
    protected boolean isPriority;
    protected LightColor currentLight = LightColor.RED;
    protected Intersection intersection;

    public Vehicle(String name, int speed, boolean isPriority, Intersection intersection) {
        this.name = name;
        this.speed = speed;
        this.isPriority = isPriority;
        this.intersection = intersection;
    }

    @Override
    public void update(LightColor color) {
        this.currentLight = color;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(3000)); // đến ngã tư

            System.out.println(name + " arrived. Light = " + currentLight);

            // Nếu không phải xe ưu tiên → phải chờ đèn xanh
            if (!isPriority) {
                while (currentLight != LightColor.GREEN) {
                    System.out.println(name + " waiting...");
                    Thread.sleep(1000);
                }
            } else {
                System.out.println("🚑 " + name + " (PRIORITY) IGNORE RED LIGHT!");
            }

            intersection.enter(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// ================== CONCRETE VEHICLE ==================
class Car extends Vehicle {
    public Car(String name, Intersection intersection) {
        super(name, 60, false, intersection);
    }
}

class Bike extends Vehicle {
    public Bike(String name, Intersection intersection) {
        super(name, 40, false, intersection);
    }
}

class Ambulance extends Vehicle {
    public Ambulance(String name, Intersection intersection) {
        super(name, 80, true, intersection);
    }
}

// ================== FACTORY ==================
class VehicleFactory {
    private static int counter = 1;
    private static Random rand = new Random();

    public static Vehicle createVehicle(Intersection intersection) {
        int type = rand.nextInt(3);

        switch (type) {
            case 0:
                return new Car("Car#" + counter++, intersection);
            case 1:
                return new Bike("Bike#" + counter++, intersection);
            default:
                return new Ambulance("Ambulance#" + counter++, intersection);
        }
    }
}

// ================== MAIN ==================
public class Main {
    public static void main(String[] args) {

        Intersection intersection = new Intersection();
        TrafficLight trafficLight = new TrafficLight();

        // Thread đèn giao thông
        Thread lightThread = new Thread(trafficLight);
        lightThread.setDaemon(true);
        lightThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Sinh xe liên tục
        for (int i = 0; i < 10; i++) {
            Vehicle v = VehicleFactory.createVehicle(intersection);
            trafficLight.attach(v);
            executor.execute(v);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

        executor.shutdown();
    }
}