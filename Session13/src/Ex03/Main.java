package Ex03;

import java.sql.*;

public class Main {

    public static void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psUpdateWallet = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psUpdatePatient = null;
        ResultSet rs = null;

        try {
            // conn = DatabaseManager.getConnection();

            // Tắt auto commit để bắt đầu transaction
            conn.setAutoCommit(false);

            // =========================
            // BẪY 1: KIỂM TRA SỐ DƯ
            // =========================
            String sqlCheck = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, maBenhNhan);
            rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Bệnh nhân không tồn tại");
            }

            double balance = rs.getDouble("balance");

            if (balance < tienVienPhi) {
                // ❗ Bẫy 1: Không đủ tiền → rollback
                throw new SQLException("Không đủ tiền để thanh toán");
            }

            // =========================
            // 1. TRỪ TIỀN
            // =========================
            String sqlWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            psUpdateWallet = conn.prepareStatement(sqlWallet);
            psUpdateWallet.setDouble(1, tienVienPhi);
            psUpdateWallet.setInt(2, maBenhNhan);

            int row1 = psUpdateWallet.executeUpdate();

            // ❗ Bẫy 2: kiểm tra row affected
            if (row1 == 0) {
                throw new SQLException("Không trừ được tiền (patient không tồn tại)");
            }

            // =========================
            // 2. GIẢI PHÓNG GIƯỜNG
            // =========================
            String sqlBed = "UPDATE Beds SET status = 'EMPTY' WHERE patient_id = ?";
            psUpdateBed = conn.prepareStatement(sqlBed);
            psUpdateBed.setInt(1, maBenhNhan);

            int row2 = psUpdateBed.executeUpdate();

            // ❗ Bẫy 2
            if (row2 == 0) {
                throw new SQLException("Không cập nhật được giường");
            }

            // =========================
            // 3. CẬP NHẬT BỆNH NHÂN
            // =========================
            String sqlPatient = "UPDATE Patients SET status = 'DISCHARGED' WHERE patient_id = ?";
            psUpdatePatient = conn.prepareStatement(sqlPatient);
            psUpdatePatient.setInt(1, maBenhNhan);

            int row3 = psUpdatePatient.executeUpdate();

            // ❗ Bẫy 2
            if (row3 == 0) {
                throw new SQLException("Không cập nhật được trạng thái bệnh nhân");
            }

            // =========================
            // COMMIT
            // =========================
            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công");

        } catch (Exception e) {

            // =========================
            // ROLLBACK KHI LỖI
            // =========================
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Đã rollback giao dịch");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Lỗi: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psUpdateWallet != null) psUpdateWallet.close();
                if (psUpdateBed != null) psUpdateBed.close();
                if (psUpdatePatient != null) psUpdatePatient.close();

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
        xuatVienVaThanhToan(1, 1000000);
    }
}