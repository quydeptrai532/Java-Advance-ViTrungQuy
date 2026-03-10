package btth;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService service = new UserService();

        List<User> users = List.of(
                new User("U01","a@gmail.com","123",true, LocalDate.now().minusMonths(30)),
                new User("U02","b@gmail.com","123",false, LocalDate.now().minusMonths(10)),
                new User("U03","c@gmail.com","123",true, LocalDate.now().minusMonths(15)),
                new User("U04","d@gmail.com","123",true, LocalDate.now().minusMonths(5)),
                new User("U05","e@gmail.com","123",false, LocalDate.now().minusMonths(40))
        );

        List<PublicUser> result =
                service.getVerifiedUsers(users)
                        .stream()
                        .map(service::toPublicUser)
                        .toList();

        System.out.println("""
                ===== USER REPORT =====
                """);

        result.forEach(System.out::println);
    }
}