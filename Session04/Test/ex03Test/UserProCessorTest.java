package ex03Test;

import ex03.UserProCessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserProCessorTest {
    UserProCessor newUser;
    @BeforeEach
    void setUp(){
        newUser=new UserProCessor();
    }
    @Test
    void testCase1(){
        String result=newUser.processEmail("user@gmail.com");
        Assertions.assertEquals("user@gmail.com",result);
    }
    @Test
    void testCase2(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> newUser.processEmail("usergmail.com")
        );
    }
    @Test
    void testCase3(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> newUser.processEmail("user@")
        );
    }
    @Test
    void testCase4(){

        String result = newUser.processEmail("Example@Gmail.com");

        Assertions.assertEquals("example@gmail.com", result);
    }
}
