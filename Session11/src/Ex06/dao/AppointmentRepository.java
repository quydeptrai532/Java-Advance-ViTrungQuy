package Ex06.dao;

import Ex05.util.DBUtility;
import Ex06.entity.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentRepository {

    public ArrayList<Appointments> getAllAppointments() {
        ArrayList<Appointments> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM appointments";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Appointments newA = new Appointments();
                newA.setId(rs.getInt("id"));
                newA.setPatientName(rs.getString("patient_name"));
                newA.setAppointmentDate(rs.getString("appointment_date"));
                newA.setDoctorName(rs.getString("doctor_name"));
                newA.setStatus(rs.getString("status"));
                list.add(newA);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, rs);
        }
    }

    public void addAppointment(Appointments appointment) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO appointments(patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, appointment.getPatientName());
            ps.setString(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, null);
        }
    }

    public void updateAppointment(Appointments appointment) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE appointments SET patient_name = ?, appointment_date = ?, doctor_name = ?, status = ? WHERE id = ?";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, appointment.getPatientName());
            ps.setString(2, appointment.getAppointmentDate());
            ps.setString(3, appointment.getDoctorName());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, null);
        }
    }

    public void deleteAppointment(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM appointments WHERE id = ?";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, null);
        }
    }

    public Appointments getAppointmentById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM appointments WHERE id = ?";

        try {
            conn = DBUtility.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Appointments appointment = new Appointments();
                appointment.setId(rs.getInt("id"));
                appointment.setPatientName(rs.getString("patient_name"));
                appointment.setAppointmentDate(rs.getString("appointment_date"));
                appointment.setDoctorName(rs.getString("doctor_name"));
                appointment.setStatus(rs.getString("status"));
                return appointment;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(conn, ps, rs);
        }
    }
}