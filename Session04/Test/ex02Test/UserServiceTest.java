package ex02Test;

import ex02.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    UserService newUser=new UserService();
    @Test
    void testCase1(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> newUser.checkRegistrationAge(-1));
    }
    @Test
    void testCase2(){
        boolean result= newUser.checkRegistrationAge(19);
        Assertions.assertEquals(true,result);
    }
    @Test
    void testCase3(){
        boolean result= newUser.checkRegistrationAge(17);
        Assertions.assertEquals(false,result);
    }

}
