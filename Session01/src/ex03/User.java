package ex03;

import btth.InvalidAgeException;

public class User  {
    protected int age;

    public User(int age) throws InvalidAgeException{
        if ( age <0){
            throw new InvalidAgeException("Tuoi khong hop le");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if ( age <0){
            throw new InvalidAgeException("Tuoi khong hop le");
        }
        this.age=age;
    }
}
