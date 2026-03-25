package Ex01;

import java.sql.*;

public class Main {

    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            //conn = DatabaseManager.getConnection();

            //  Tắt auto-commit
            conn.setAutoCommit(false);

            // 1. Trừ thuốc
            String sqlUpdate = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            ps1 = conn.prepareStatement(sqlUpdate);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            //  Giả lập lỗi (test)
            int x = 10 / 0;

            // 2. Lưu lịch sử
            String sqlInsert = "INSERT INTO Prescription_History(patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
            ps2 = conn.prepareStatement(sqlInsert);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            //  Thành công hết → COMMIT
            conn.commit();

            System.out.println("Cấp phát thuốc thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    //  Có lỗi → rollback toàn bộ
                    conn.rollback();
                    System.out.println("Rollback do lỗi!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Lỗi xảy ra: " + e.getMessage());

        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();

                if (conn != null) {
                    // bật lại auto-commit (best practice)
                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}