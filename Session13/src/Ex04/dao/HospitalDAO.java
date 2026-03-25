package Ex04.dao;

import Ex04.util.DBUtil;

import java.sql.*;

public class HospitalDAO {

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psWallet = null;
        PreparedStatement psBed = null;
        PreparedStatement psPatient = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            // bắt đầu transaction
            conn.setAutoCommit(false);

            // =========================
            // BẪY 1: CHECK SỐ DƯ
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
                // Bẫy 1
                throw new SQLException("Không đủ tiền");
            }

            // =========================
            // 1. TRỪ TIỀN
            // =========================
            String sqlWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            psWallet = conn.prepareStatement(sqlWallet);
            psWallet.setDouble(1, tienVienPhi);
            psWallet.setInt(2, maBenhNhan);

            int row1 = psWallet.executeUpdate();

            if (row1 == 0) {
                // Bẫy 2
                throw new SQLException("Không trừ được tiền");
            }

            // =========================
            // 2. GIẢI PHÓNG GIƯỜNG
            // =========================
            String sqlBed = "UPDATE Beds SET status = 'EMPTY' WHERE patient_id = ?";
            psBed = conn.prepareStatement(sqlBed);
            psBed.setInt(1, maBenhNhan);

            int row2 = psBed.executeUpdate();

            if (row2 == 0) {
                // Bẫy 2
                throw new SQLException("Không update được giường");
            }

            // =========================
            // 3. UPDATE BỆNH NHÂN
            // =========================
            String sqlPatient = "UPDATE Patients SET status = 'DISCHARGED' WHERE patient_id = ?";
            psPatient = conn.prepareStatement(sqlPatient);
            psPatient.setInt(1, maBenhNhan);

            int row3 = psPatient.executeUpdate();

            if (row3 == 0) {
                // Bẫy 2
                throw new SQLException("Không update được bệnh nhân");
            }

            // commit
            conn.commit();
            System.out.println("Xuất viện thành công");

        } catch (Exception e) {

            // rollback khi lỗi
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
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psWallet != null) psWallet.close();
                if (psBed != null) psBed.close();
                if (psPatient != null) psPatient.close();

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