package ex01;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {


    public static void main(String[] args) {
        record User(String username,String email, String status){}
        User user1=new User("Quydz1","Quydz1@gmail.com","ACTIVE");
        User user2=new User("Quydz2","Quydz2@gmail.com","INACTIVE");
        User user3=new User("Quydz3","Quydz3@gmail.com","ACTIVE");
        List<User> list=new ArrayList<>();
        list= List.of(user1,user2,user3);
        list.forEach(user -> {System.out.println(user.toString());});
    }
}
