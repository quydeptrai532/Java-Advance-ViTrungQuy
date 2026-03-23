package Ex05.dao;

import Ex05.entity.Patient;
import Ex05.util.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientRepo {

    public ArrayList<Patient> listPatient() {
        ArrayList<Patient> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM patient";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setAge(rs.getInt("age"));
                patient.setDepartment(rs.getString("department"));

                list.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, rs);
        }

        return list;
    }

    public void showAllPatients() {
        ArrayList<Patient> list = listPatient();

        if (list.isEmpty()) {
            System.out.println("Danh sach benh nhan dang rong");
            return;
        }

        System.out.println("===== DANH SACH BENH NHAN =====");
        for (Patient patient : list) {
            System.out.println(patient);
        }
    }

    public void addPatient() {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO patient(name, age, department) VALUES(?,?,?)";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);

            System.out.println("Moi ban nhap vao ten cua benh nhan");
            ps.setString(1, sc.nextLine());

            System.out.println("Moi ban nhap vao tuoi cua benh nhan");
            ps.setInt(2, Integer.parseInt(sc.nextLine()));

            System.out.println("Moi ban nhap vao khoa cua benh nhan");
            ps.setString(3, sc.nextLine());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Them benh nhan thanh cong");
            } else {
                System.out.println("Them benh nhan that bai");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, null);
        }
    }

    public boolean updatePatient(int idUpdate) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement psCheck = null;
        PreparedStatement psUpdate = null;
        ResultSet rs = null;

        String sql1 = "SELECT * FROM patient WHERE id = ?";
        String sql2 = "UPDATE patient SET name = ?, age = ?, department = ? WHERE id = ?";

        try {
            conn = DBUtility.getConnection();

            psCheck = conn.prepareStatement(sql1);
            psCheck.setInt(1, idUpdate);
            rs = psCheck.executeQuery();

            if (!rs.next()) {
                System.out.println("Khong tim thay benh nhan can update");
                return false;
            }

            psUpdate = conn.prepareStatement(sql2);

            System.out.println("Moi ban nhap vao ten moi");
            psUpdate.setString(1, sc.nextLine());

            System.out.println("Moi ban nhap vao tuoi moi");
            psUpdate.setInt(2, Integer.parseInt(sc.nextLine()));

            System.out.println("Moi ban nhap vao khoa moi");
            psUpdate.setString(3, sc.nextLine());

            psUpdate.setInt(4, idUpdate);

            int rows = psUpdate.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psUpdate != null) psUpdate.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public double totalConsume(int days) {
        Connection conn = null;
        CallableStatement cs = null;

        try {
            conn = DBUtility.getConnection();
            cs = conn.prepareCall("{call CALCULATE_DISCHARGE_FEE(?, ?)}");

            cs.setInt(1, days);
            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

            return cs.getDouble(2);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (cs != null) cs.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}