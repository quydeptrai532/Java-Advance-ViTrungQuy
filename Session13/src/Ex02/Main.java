package Ex02;

import java.sql.*;

public class Main {

    public static void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            //conn = DatabaseManager.getConnection();

            // tắt auto commit
            conn.setAutoCommit(false);

            // trừ tiền ví
            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            // lỗi cố tình (ví dụ sai tên bảng)
            String sqlUpdateInvoice = "UPDATE Invoicess SET status = 'PAID' WHERE invoice_id = ?";
            ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            // commit nếu mọi thứ ok
            conn.commit();
            System.out.println("Thanh toán hoàn tất");

        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());

            // hành động bắt buộc: rollback
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback dữ liệu");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        thanhToanVienPhi(1, 101, 500000);
    }
}