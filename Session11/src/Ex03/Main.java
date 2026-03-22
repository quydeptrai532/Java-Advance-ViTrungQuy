package Ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        int inputId = 999; // vi du ma giuong duoc nhap

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database",
                    "root",
                    "your_password"
            );

            stmt = conn.createStatement();

            String sql = "UPDATE Beds SET bed_status = 'Dang su dung' WHERE bed_id = " + inputId;

            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Da cap nhat trang thai giuong benh thanh cong!");
            } else {
                System.out.println("Loi: Ma giuong nay khong ton tai.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}