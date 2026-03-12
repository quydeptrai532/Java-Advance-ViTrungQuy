package ex04Test;

import ex04.PasswordEvaluator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordEvaluatorTest {

    PasswordEvaluator evaluator;

    @BeforeEach
    void setup() {
        evaluator = new PasswordEvaluator();
    }

    @Test
    void testStrongPassword() {

        String result = evaluator.evaluatePasswordStrength("Abc123!@");

        Assertions.assertEquals("Mạnh", result);
    }

    @Test
    void testMediumPasswords() {

        Assertions.assertAll(

                () -> Assertions.assertEquals(
                        "Trung bình",
                        evaluator.evaluatePasswordStrength("abc123!@")
                ),

                () -> Assertions.assertEquals(
                        "Trung bình",
                        evaluator.evaluatePasswordStrength("ABC123!@")
                ),

                () -> Assertions.assertEquals(
                        "Trung bình",
                        evaluator.evaluatePasswordStrength("Abcdef!@")
                ),

                () -> Assertions.assertEquals(
                        "Trung bình",
                        evaluator.evaluatePasswordStrength("Abc12345")
                )
        );
    }

    @Test
    void testWeakPasswords() {

        Assertions.assertAll(

                () -> Assertions.assertEquals(
                        "Yếu",
                        evaluator.evaluatePasswordStrength("Ab1!")
                ),

                () -> Assertions.assertEquals(
                        "Yếu",
                        evaluator.evaluatePasswordStrength("password")
                ),

                () -> Assertions.assertEquals(
                        "Yếu",
                        evaluator.evaluatePasswordStrength("ABC12345")
                )
        );
    }
}