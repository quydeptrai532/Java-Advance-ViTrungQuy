package Ex06.dao;

import Ex06.entity.Medicine;
import Ex06.util.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalDAO {

    // Bước 1: cập nhật tồn kho
    public boolean updateMedicineStock(int id, int addedQuantity) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE medicines SET stock = stock + ? WHERE id = ?";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);

            // Tham số 1: số lượng thêm
            ps.setInt(1, addedQuantity);

            // Tham số 2: id thuốc
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Loi updateMedicineStock: " + e.getMessage());
            return false;
        } finally {
            DBUtility.closeAll(conn, ps, null);
        }
    }

    // Bước 2: tìm thuốc theo khoảng giá
    public List<Medicine> findMedicinesByPriceRange(double minPrice, double maxPrice) {
        List<Medicine> medicines = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM medicines WHERE price BETWEEN ? AND ?";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setDouble(1, minPrice);
            ps.setDouble(2, maxPrice);

            rs = ps.executeQuery();

            while (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                medicine.setPrice(rs.getDouble("price"));
                medicine.setStock(rs.getInt("stock"));

                medicines.add(medicine);
            }

        } catch (SQLException e) {
            System.out.println("Loi findMedicinesByPriceRange: " + e.getMessage());
        } finally {
            DBUtility.closeAll(conn, ps, rs);
        }

        return medicines;
    }

    // Bước 3: gọi procedure tính tổng tiền 1 đơn thuốc
    public double calculatePrescriptionTotal(int prescriptionId) {
        Connection conn = null;
        CallableStatement cs = null;

        double total = 0;

        String sql = "{CALL CalculatePrescriptionTotal(?, ?)}";

        try {
            conn = DBUtility.getConnection();
            cs = conn.prepareCall(sql);

            // IN
            cs.setInt(1, prescriptionId);

            // OUT
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            total = cs.getDouble(2);

        } catch (SQLException e) {
            System.out.println("Loi calculatePrescriptionTotal: " + e.getMessage());
        } finally {
            DBUtility.closeAll(conn, cs, null);
        }

        return total;
    }

    // Bước 4: gọi procedure thống kê doanh thu theo ngày
    public double getDailyRevenue(Date saleDate) {
        Connection conn = null;
        CallableStatement cs = null;

        double revenue = 0;

        String sql = "{CALL GetDailyRevenue(?, ?)}";

        try {
            conn = DBUtility.getConnection();
            cs = conn.prepareCall(sql);

            // IN
            cs.setDate(1, saleDate);

            // OUT
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            revenue = cs.getDouble(2);

        } catch (SQLException e) {
            System.out.println("Loi getDailyRevenue: " + e.getMessage());
        } finally {
            DBUtility.closeAll(conn, cs, null);
        }

        return revenue;
    }

    // Hàm phụ: hiển thị danh sách thuốc
    public void displayMedicines(List<Medicine> medicines) {
        if (medicines == null || medicines.isEmpty()) {
            System.out.println("Khong co thuoc nao trong khoang gia nay.");
            return;
        }

        System.out.println("===== DANH SACH THUOC =====");
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }
}