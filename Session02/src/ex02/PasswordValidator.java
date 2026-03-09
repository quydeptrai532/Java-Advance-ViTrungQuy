package ex02;
@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
