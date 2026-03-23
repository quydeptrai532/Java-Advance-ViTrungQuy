package Ex03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            // Giả sử đã có hàm lấy kết nối
            // conn = DBUtility.getConnection();
            int surgeryId = 505;
            String sql = "{call GET_SURGERY_FEE(?, ?)}";
            cstmt = conn.prepareCall(sql);
            // Tham so IN
            cstmt.setInt(1, surgeryId);
            // Tham so OUT kieu DECIMAL
            cstmt.registerOutParameter(2, Types.DECIMAL);
            // Thuc thi procedure
            cstmt.execute();
            // Lay gia tri tra ve
            double cost = cstmt.getDouble(2);
            System.out.println("Chi phi phau thuat cua ca phau thuat " + surgeryId + " la: " + cost);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}