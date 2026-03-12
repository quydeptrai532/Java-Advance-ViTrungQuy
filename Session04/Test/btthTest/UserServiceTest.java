package btthTest;

import btth.User;
import btth.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    UserService newUserService;

    @BeforeEach
    void setup() {
         newUserService = new UserService();
    }

    @Test
    void testUserAddSuccess() {
        User newUser1= new User(1,"Quydz","Quydz@gmail.com");
        newUserService.addUser(newUser1);
        Assertions.assertEquals(1,newUserService.getSize());
    }
    @Test
    void testNameValid(){
        User newUser1= new User(2,null,"Quydz@gmail.com");
        Assertions.assertThrows(IllegalArgumentException.class,()-> newUserService.addUser(newUser1));
    }
    @Test
    void testFindUserById(){
        User newUser1= new User(1,"Quydz","Quydz@gmail.com");
        newUserService.addUser(newUser1);
        User result=newUserService.findUserById(1);
        Assertions.assertNotNull(result);
    }
    @Test
    void testIsValidEmail(){
        String email="abc@gmail.com";
        boolean result=newUserService.isValidEmail(email);
        Assertions.assertTrue(result);
    }

}
