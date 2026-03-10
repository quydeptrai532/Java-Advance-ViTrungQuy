package ex04;

import ex03.User;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "alice"),
                new User(2, "bob"),
                new User(3, "alice"),
                new User(4, "charlie"),
                new User(5, "bob")
        );

        List<User> uniqueUsers = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        u -> u,
                        (u1, u2) -> u1
                ))
                .values()
                .stream()
                .toList();

        uniqueUsers.forEach(System.out::println);
    }
}