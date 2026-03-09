package btth;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.prefs.AbstractPreferences;

public class UserManagement {
    Supplier<User> newUser=User::new;
    Predicate<User> isActive=u -> u.getStatus().equals("ACTIVE");
    Function<User,String> email=User::getEmail;
 }

