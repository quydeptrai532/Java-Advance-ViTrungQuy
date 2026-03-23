package Ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String code = "123";
        String pass = "345";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Giả sử conn đã được tạo ở chỗ khác
            // conn = DBUtility.getConnection();
            String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Dang nhap thanh cong!");
                System.out.println("Doctor Code: " + rs.getString("code"));
            } else {
                System.out.println("Sai ma bac si hoac mat khau!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}