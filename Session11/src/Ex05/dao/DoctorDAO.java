package Ex05.dao;

import Ex05.entity.Doctor;
import Ex05.util.DBUtility;

import java.sql.*;
import java.util.ArrayList;

public class DoctorDAO {
    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id, name, specialty FROM doctors";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialty(rs.getString("specialty"));
                list.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(conn, ps, rs);
        }

        return list;
    }


    public boolean addDoctor(Doctor doctor){
        Connection conn=null;
        PreparedStatement ps=null;
        String sql="Insert into doctors(id,name,specialty) Values(?,?,?)";
        try {
            conn=DBUtility.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,doctor.getId());
            ps.setString(2,doctor.getName());
            ps.setString(3, doctor.getSpecialty());
            int rows=ps.executeUpdate();
            return  rows >0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            DBUtility.closeAll(conn,ps,null);
        }
    }

    public void countSpecial(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "SELECT specialty, COUNT(*) AS total FROM doctors GROUP BY specialty";

        try {
            conn=DBUtility.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                String specialty=rs.getString("specialty");
                int total=rs.getInt("total");
                System.out.println("Chuyen khoa :"+specialty+" | so luong :" +total);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtility.closeAll(conn,ps,rs)  ;
        }
    }
}
