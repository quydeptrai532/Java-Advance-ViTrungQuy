package ex03;

public interface Authenticatable {
    String getPassword();
    default boolean isAuthenticated(){
        return !getPassword().isBlank();
    }
    static String encrypt(String rawPassword){
        return "";
    }
}
