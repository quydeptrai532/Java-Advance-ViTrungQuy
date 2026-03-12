package btth;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> userList=new ArrayList<>();
     public void addUser(User user){
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        userList.add(user);
    }
    public User findUserById(int id){
        for(User u:userList){
           if(u.getId()==id){
               return u;
           }

        }
        return null;
    }
    public boolean isValidEmail(String email){
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@");
    }
    public int getSize() {
        return userList.size();
    }
}
