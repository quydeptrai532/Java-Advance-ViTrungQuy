package btth;
@FunctionalInterface
public interface IUserAccount {
    String getRole();
    default boolean checkAccess(){
        if (getRole().equals("ADMIN")){
            return true;
        }
        else return false;
    }
    static boolean isStandardLength(String username){
        if(username.length()>5){
            return true;
        }
        return false;
    }
}
