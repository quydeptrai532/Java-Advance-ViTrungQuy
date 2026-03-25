package Ex06.dao;

import Ex06.util.DBUtil;

import java.sql.*;

public class HospitalDAO {

    public void xuatVien(int patientId, double amount) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;

        try {
            conn = DBUtil.getConnection();

            // bắt đầu transaction
            conn.setAutoCommit(false);

            // =========================
            // 1. TẠO HÓA ĐƠN
            // =========================
            String sql1 = "INSERT INTO INVOICES(patient_id, amount) VALUES (?, ?)";
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, patientId);
            ps1.setDouble(2, amount);

            int row1 = ps1.executeUpdate();
            if (row1 == 0) {
                throw new SQLException("Tạo hóa đơn thất bại");
            }

            // =========================
            // 2. UPDATE PATIENT
            // =========================
            String sql2 = "UPDATE PATIENTS SET status = 'Đã xuất viện' WHERE patient_id = ?";
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, patientId);

            int row2 = ps2.executeUpdate();
            if (row2 == 0) {
                throw new SQLException("Không tìm thấy bệnh nhân");
            }

            // =========================
            // 3. UPDATE BED
            // =========================
            String sql3 = "UPDATE BEDS SET status = 'Trống', patient_id = NULL WHERE patient_id = ?";
            ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, patientId);

            int row3 = ps3.executeUpdate();
            if (row3 == 0) {
                throw new SQLException("Không cập nhật được giường");
            }

            // commit nếu thành công hết
            conn.commit();
            System.out.println("Xuất viện thành công");

        } catch (Exception e) {

            // rollback nếu có lỗi
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rollback do lỗi");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Lỗi: " + e.getMessage());

        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (ps3 != null) ps3.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}