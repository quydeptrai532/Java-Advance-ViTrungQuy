package ex05;

public class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        // chọn gọi interface nào
        UserActions.super.logActivity(activity);

        // hoặc
        // AdminActions.super.logActivity(activity);
    }
}