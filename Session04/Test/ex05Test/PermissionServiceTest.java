package ex05Test;

import ex05.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PermissionServiceTest {

    PermissionService service;
    User user;

    @BeforeEach
    void setup(){
        service = new PermissionService();
    }

    @AfterEach
    void cleanup(){
        user = null;
    }

    // ===== ADMIN TEST =====

    @Test
    void adminCanDoEverything(){

        user = new User(Role.ADMIN);

        Assertions.assertAll(

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.DELETE_USER)
                ),

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.LOCK_USER)
                ),

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.VIEW_PROFILE)
                )
        );
    }

    // ===== MODERATOR TEST =====

    @Test
    void moderatorPermissions(){

        user = new User(Role.MODERATOR);

        Assertions.assertAll(

                () -> Assertions.assertFalse(
                        service.canPerformAction(user, Action.DELETE_USER)
                ),

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.LOCK_USER)
                ),

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.VIEW_PROFILE)
                )
        );
    }

    // ===== USER TEST =====

    @Test
    void userPermissions(){

        user = new User(Role.USER);

        Assertions.assertAll(

                () -> Assertions.assertFalse(
                        service.canPerformAction(user, Action.DELETE_USER)
                ),

                () -> Assertions.assertFalse(
                        service.canPerformAction(user, Action.LOCK_USER)
                ),

                () -> Assertions.assertTrue(
                        service.canPerformAction(user, Action.VIEW_PROFILE)
                )
        );
    }
}