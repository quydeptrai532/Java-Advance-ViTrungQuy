package ex06;

public class Main {

    public static void main(String[] args) {

        // Method Reference tới static method
        UserProcessor processor = UserUtils::convertToUpperCase;

        User user = new User("admin01");

        String result = processor.process(user);

        System.out.println(result);
    }
}