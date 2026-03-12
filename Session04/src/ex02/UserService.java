package ex02;

public class UserService {
    public boolean checkRegistrationAge(int age){
        if(age<0){
            throw  new IllegalArgumentException("Tuoi nhap vao khong duoc la so am");
        }
        return  age>17;
    }
}
