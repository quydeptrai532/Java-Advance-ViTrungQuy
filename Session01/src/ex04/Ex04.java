package ex04;

import java.io.IOException;

public class Ex04 {
    static public void saveToFile() throws IOException {
        System.out.println("Luu du lieu");
        throw new IOException("Loi luu du lieu");
    }
    static public void processUserData() throws IOException{
        System.out.println("Xu ly du lieu nguoi dung");
        saveToFile();
    }

    public static void main(String[] args) {
        try{
           processUserData();
        }
        catch (IOException e){
           System.err.println("Da xay ra loi:"+e.getMessage());
        }
        finally {
          System.out.println("Don dep bo nho");
        }
    }
}
