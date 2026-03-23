package Ex04;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        String[] results = {"HB: 13.5", "WBC: 7000", "PLT: 250000"};
        try {
            // conn = DBUtility.getConnection();
            String sql = "INSERT INTO Results(data) VALUES(?)";
            ps = conn.prepareStatement(sql);
            for (String data : results) {
                ps.setString(1, data);
                ps.executeUpdate();
            }
            System.out.println("Nap ket qua xet nghiem thanh cong!");
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