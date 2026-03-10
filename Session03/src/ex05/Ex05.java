package ex05;

import java.util.*;

public class Ex05 {
    public static void main(String[] args) {

        record Users(int id, String username) {}

        List<Users> users = List.of(
                new Users(1,"alex"),
                new Users(2,"alexander"),
                new Users(3,"bob"),
                new Users(4,"charlotte"),
                new Users(5,"Benjamin"),
                new Users(6,"tom")
        );

        users.stream()
                .sorted(Comparator.comparingInt((Users u) -> u.username().length()).reversed())
                .limit(3)
                .map(Users::username)
                .forEach(System.out::println);
    }
}