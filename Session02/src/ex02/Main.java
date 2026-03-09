package ex02;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator=new PasswordValidator() {
            @Override
            public boolean isValid(String password) {
                return password.length() >=8;
            }
        };
        PasswordValidator pass= password -> password.length()>=8;

    }
}
