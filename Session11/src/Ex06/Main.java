package Ex06;

import Ex06.bussiness.AppointmentBusiness;
import Ex06.entity.Appointments;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AppointmentBusiness business = new AppointmentBusiness();

        // 1. Thêm lịch khám mới
        Appointments a1 = new Appointments();
        a1.setPatientName("Nguyen Van A");
        a1.setAppointmentDate("2026-03-22");
        a1.setDoctorName("Dr. Minh");
        a1.setStatus("Pending");
        business.addAppointment(a1);
        System.out.println("Them lich kham thanh cong!");

        // 2. Hiển thị tất cả lịch khám
        System.out.println("\nDanh sach lich kham:");
        ArrayList<Appointments> list = business.getAllAppointments();
        for (Appointments a : list) {
            System.out.println(a);
        }

        // 3. Cập nhật lịch khám theo id
        Appointments updateAppointment = business.getAppointmentById(1);
        if (updateAppointment != null) {
            updateAppointment.setPatientName("Nguyen Van B");
            updateAppointment.setAppointmentDate("2026-03-25");
            updateAppointment.setDoctorName("Dr. Hung");
            updateAppointment.setStatus("Confirmed");

            business.updateAppointment(updateAppointment);
            System.out.println("\nCap nhat lich kham thanh cong!");
        } else {
            System.out.println("\nKhong tim thay lich kham de cap nhat!");
        }

        // 4. Xóa lịch khám theo id
        business.deleteAppointment(2);
        System.out.println("\nXoa lich kham thanh cong!");

        // 5. Hiển thị lại danh sách sau khi cập nhật và xóa
        System.out.println("\nDanh sach lich kham sau khi cap nhat va xoa:");
        list = business.getAllAppointments();
        for (Appointments a : list) {
            System.out.println(a);
        }
    }
}