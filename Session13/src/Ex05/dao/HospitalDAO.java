package Ex05.dao;

import Ex05.util.DBUtil;

import java.sql.*;

public class HospitalDAO {

    public void tiepNhanBenhNhan(String name, int age, int bedId, double amount) {
        Connection conn = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            // 1. check giường trống
            String checkBed = "SELECT status FROM Beds WHERE bed_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkBed);
            psCheck.setInt(1, bedId);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Giường không tồn tại");
            }

            if (!rs.getString("status").equals("EMPTY")) {
                throw new SQLException("Giường đã có người");
            }

            // 2. insert bệnh nhân
            String insertPatient = "INSERT INTO Patients(name, age, status, bed_id) VALUES (?, ?, 'ADMITTED', ?)";
            PreparedStatement ps1 = conn.prepareStatement(insertPatient, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, name);
            ps1.setInt(2, age);
            ps1.setInt(3, bedId);

            int row1 = ps1.executeUpdate();
            if (row1 == 0) throw new SQLException("Insert bệnh nhân thất bại");

            ResultSet keys = ps1.getGeneratedKeys();
            keys.next();
            int patientId = keys.getInt(1);

            // 3. update giường
            String updateBed = "UPDATE Beds SET status = 'OCCUPIED' WHERE bed_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateBed);
            ps2.setInt(1, bedId);

            int row2 = ps2.executeUpdate();
            if (row2 == 0) throw new SQLException("Update giường thất bại");

            // 4. insert tài chính
            String insertMoney = "INSERT INTO Transactions(patient_id, amount) VALUES (?, ?)";
            PreparedStatement ps3 = conn.prepareStatement(insertMoney);
            ps3.setInt(1, patientId);
            ps3.setDouble(2, amount);

            int row3 = ps3.executeUpdate();
            if (row3 == 0) throw new SQLException("Ghi nhận tiền thất bại");

            conn.commit();
            System.out.println("Tiếp nhận thành công");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Lỗi: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void showEmptyBeds() {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM Beds WHERE status = 'EMPTY'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("Danh sách giường trống:");
            while (rs.next()) {
                System.out.println("Bed ID: " + rs.getInt("bed_id"));
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}