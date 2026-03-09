package ex05;

public interface AdminActions {

    default void logActivity(String activity){
        System.out.println("Admin log: " + activity);
    }
}