package ex03;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    static List<User> users=List.of(new User(1,"alice"),new User(2,"Quydz2"),new User(3,"Quydz3"));
    Optional<User> findUserByUsername(String username){
        return users.stream().filter(u->u.getName().equals(username)).findFirst();
    };
    public static void main(String[] args) {
       UserRepository newU=new UserRepository();
      newU.findUserByUsername("alice")
               .ifPresentOrElse(u->System.out.println("Welecome " +u.getName()),()->System.out.println("Guest login"));
    }
}
