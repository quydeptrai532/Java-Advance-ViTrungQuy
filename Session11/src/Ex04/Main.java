package Ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }

        input = input.replace("--", "");
        input = input.replace(";", "");
        input = input.replace("'", "");

        return input.trim();
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String patientName = "' OR '1'='1";

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HospitalDB",
                    "root",
                    "123456$"
            );

            stmt = conn.createStatement();

            String safePatientName = sanitizeInput(patientName);

            String sql = "SELECT * FROM Patients WHERE full_name = '" + safePatientName + "'";

            System.out.println("Cau lenh SQL sau khi xu ly: " + sql);

            rs = stmt.executeQuery(sql);

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
                System.out.println("Ma BN: " + rs.getInt("patient_id"));
                System.out.println("Ho ten: " + rs.getString("full_name"));
                System.out.println("-------------------------");
            }

            if (!hasData) {
                System.out.println("Khong tim thay benh nhan.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}