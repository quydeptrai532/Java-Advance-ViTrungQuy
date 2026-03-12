package ex06Test;

import ex06.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserProfileServiceTest {

    UserProfileService service;
    List<User> users;

    @BeforeEach
    void setup(){
        service = new UserProfileService();
        users = new ArrayList<>();
    }

    @Test
    void shouldUpdateProfileSuccessfully(){

        User existing = new User("old@gmail.com", LocalDate.of(2000,1,1));
        users.add(existing);

        UserProfile newProfile =
                new UserProfile("new@gmail.com", LocalDate.of(1999,1,1));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNotNull(result);
    }

    @Test
    void shouldRejectFutureBirthDate(){

        User existing = new User("user@gmail.com", LocalDate.of(2000,1,1));
        users.add(existing);

        UserProfile newProfile =
                new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNull(result);
    }

    @Test
    void shouldRejectDuplicateEmail(){

        User existing = new User("user@gmail.com", LocalDate.of(2000,1,1));
        User other = new User("duplicate@gmail.com", LocalDate.of(1995,1,1));

        users.add(existing);
        users.add(other);

        UserProfile newProfile =
                new UserProfile("duplicate@gmail.com", LocalDate.of(1999,1,1));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNull(result);
    }

    @Test
    void shouldAllowSameEmailUpdate(){

        User existing = new User("same@gmail.com", LocalDate.of(2000,1,1));
        users.add(existing);

        UserProfile newProfile =
                new UserProfile("same@gmail.com", LocalDate.of(1998,1,1));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNotNull(result);
    }

    @Test
    void shouldUpdateWhenUserListEmpty(){

        User existing = new User("user@gmail.com", LocalDate.of(2000,1,1));

        UserProfile newProfile =
                new UserProfile("new@gmail.com", LocalDate.of(1999,1,1));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNotNull(result);
    }

    @Test
    void shouldRejectWhenBothConditionsInvalid(){

        User existing = new User("user@gmail.com", LocalDate.of(2000,1,1));
        User other = new User("duplicate@gmail.com", LocalDate.of(1995,1,1));

        users.add(existing);
        users.add(other);

        UserProfile newProfile =
                new UserProfile("duplicate@gmail.com",
                        LocalDate.now().plusDays(2));

        User result = service.updateProfile(existing,newProfile,users);

        Assertions.assertNull(result);
    }
}