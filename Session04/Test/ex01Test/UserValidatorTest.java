package ex01Test;

import ex01.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserValidatorTest {
    UserValidator newUser=new UserValidator();
    @Test
    void testcase1(){
      boolean isValid= newUser.isValidUsername("Quydz1");
        Assertions.assertTrue(isValid);
    }
    @Test
    void testcase2(){
        boolean isValid= newUser.isValidUsername("");
        Assertions.assertFalse(isValid);
    }
    @Test
    void testcase3(){
        boolean isValid= newUser.isValidUsername("quy  cc");
        Assertions.assertFalse(isValid);
    }
}
