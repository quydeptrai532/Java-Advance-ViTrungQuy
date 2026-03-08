package ex05;

import btth.InvalidAgeException;
import ex03.User;

public class Main {
    public static void main(String[] args) throws InvalidAgeException {
        User u=new User(-10);
        try {
            u.setAge(-12);
        }
        finally {
            System.out.println("Hello");
        }
    }
}
