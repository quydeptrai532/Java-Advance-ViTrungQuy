package btth;

import java.io.FileNotFoundException;

public class UserService {

    public static String registerUser(String name, String ageInput, String email)
            throws InvalidAgeException, InvalidEmailException {

        int age;

        try {
            age = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            throw e;
        }

        if (age < 18) {
            throw new InvalidAgeException(
                    "Lỗi nghiệp vụ: Tuổi không đủ để đăng ký hệ thống.");
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException(
                    "Lỗi nghiệp vụ: Email không hợp lệ.");
        }

        return name + " - " + age + " - " + email;
    }

    public static void saveUserToFile(String userData)
            throws FileNotFoundException {

        // giả lập lỗi hệ thống
        throw new FileNotFoundException("Không tìm thấy file lưu trữ.");

        // nếu muốn test thành công thì dùng
        // System.out.println("Đã lưu: " + userData);
    }

}