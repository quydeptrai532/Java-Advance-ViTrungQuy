package ex04;
import btth.User;
import java.util.*;
import java.util.function.*;

public class Ex04 {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("admin","admin@gmail.com","ADMIN","ACTIVE"));
        users.add(new User("user1","user1@gmail.com","USER","ACTIVE"));
        users.add(new User("guest","guest@gmail.com","USER","INACTIVE"));
        Function<User,String> getUsername = User::getUserName;
        users.forEach(System.out::println);
        Supplier<User> createUser = User::new;
        User u = createUser.get();
    }
}