package ex02;

import java.util.List;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        record User(String name,String email){}
        User user1= new User("Quydz1","quydz1@gmail.com");
        User user2= new User("Quydz2","quydz2@gmail.com");
        User user3= new User("Quydz3","quydz3@vn.com");
        User user4= new User("Quydz4","quydz4@china.com");
        List<User> list =List.of(user1,user2,user3,user4);
        list.stream().filter(user ->  user.email().endsWith("@gmail.com")).forEach(u->System.out.println(u.name()));
    }
}
