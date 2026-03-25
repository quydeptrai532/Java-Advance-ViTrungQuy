package KT.dao;
import KT.until.DBUtility;

import java.sql.*;

public class BankRepo {

    public void transfer(String fromId, String toId, double amount) {

        String checkSQL = "SELECT Balance FROM Accounts WHERE AccountId = ?";
        String callSP = "{CALL sp_UpdateBalance(?, ?)}";
        String resultSQL = "SELECT * FROM Accounts WHERE AccountId IN (?, ?)";
        try (Connection conn = DBUtility.getConnection()) {
            conn.setAutoCommit(false);
            // 1. Kiểm tra tài khoản gửi
            double balance;
            try (PreparedStatement ps = conn.prepareStatement(checkSQL)) {
                ps.setString(1, fromId);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("Tài khoản gửi không tồn tại!");
                }
                balance = rs.getDouble("Balance");
                if (balance < amount) {
                    throw new SQLException("Không đủ số dư!");
                }
            }
            // 2. Gọi Stored Procedure
            try (CallableStatement cs = conn.prepareCall(callSP)) {
                // Trừ tiền A
                cs.setString(1, fromId);
                cs.setDouble(2, -amount);
                cs.execute();
                // Cộng tiền B
                cs.setString(1, toId);
                cs.setDouble(2, amount);
                cs.execute();
            }
            // 3. Commit
            conn.commit();
            System.out.println(" Chuyển tiền thành công!");
            // 4. Hiển thị kết quả
            try (PreparedStatement ps = conn.prepareStatement(resultSQL)) {
                ps.setString(1, fromId);
                ps.setString(2, toId);
                ResultSet rs = ps.executeQuery();
                System.out.println("===== KẾT QUẢ SAU CHUYỂN =====");
                while (rs.next()) {
                    System.out.println(
                            rs.getString("AccountId") + " | " +
                                    rs.getDouble("Balance")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(" Lỗi: " + e.getMessage());
            // rollback nếu lỗi
            try (Connection conn = DBUtility.getConnection()) {
                conn.rollback();
            } catch (Exception ex) {
                System.out.println("Rollback lỗi!");
            }
        }
    }
}