package btth;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManagement um=new UserManagement();
        User user1=um.newUser.get();
        user1=new User("Quydz","Quybotuoi@gmail.com","ADMIN","ACTIVE");
        boolean isValid=IUserAccount.isStandardLength(user1.getUserName());
        System.out.println("is UserName valid? :"+isValid);
        String email=um.email.apply(user1);
        System.out.println("Email: "+email);
        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(new User("Quydz1", "Quybotuoi2@gmail.com", "USER", "ACTIVE"));
        users.add(new User("QUydz2", "Quybotuoi2@gmail.com", "USER", "INACTIVE"));
        users.add(new User("Quydz3", "Quybotuoi3@gmail.com", "ADMIN", "ACTIVE"));
        users.forEach(System.out::println);

        System.out.println("ACTIVE USER");
        users.stream().filter(um.isActive).forEach(System.out::println);
    }
}
