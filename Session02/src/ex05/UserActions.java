package ex05;

public interface UserActions {

    default void logActivity(String activity){
        System.out.println("User log: " + activity);
    }
}