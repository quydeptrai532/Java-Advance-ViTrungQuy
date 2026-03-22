package Ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database",
                    "root",
                    "your_password"
            );

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");

            System.out.println("DANH MUC THUOC TRONG KHO");
            System.out.println("-------------------------------");

            boolean hasData = false;

            while (rs.next()) {
                hasData = true;
                String medicineName = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Ten thuoc: " + medicineName + " | So luong ton kho: " + stock);
            }

            if (!hasData) {
                System.out.println("Kho thuoc hien dang trong.");
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