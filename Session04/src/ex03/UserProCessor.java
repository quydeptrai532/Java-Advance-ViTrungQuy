package ex03;

public class UserProCessor {
    public String processEmail(String email){

        if(email == null){
            throw new IllegalArgumentException("Email null");
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if(!email.matches(regex)){
            throw new IllegalArgumentException("Email không hợp lệ");
        }

        return email.toLowerCase();
    }

}
