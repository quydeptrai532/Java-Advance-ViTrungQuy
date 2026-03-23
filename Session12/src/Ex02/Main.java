package Ex02;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        int patientID = 1;
        double temp = 37.5;
        int heartRate = 88;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // Giả sử đã có hàm lấy kết nối
            // conn = DBUtility.getConnection();
            String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, temp);
            ps.setInt(2, heartRate);
            ps.setInt(3, patientID);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cap nhat chi so sinh ton thanh cong!");
            } else {
                System.out.println("Khong tim thay benh nhan de cap nhat.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}