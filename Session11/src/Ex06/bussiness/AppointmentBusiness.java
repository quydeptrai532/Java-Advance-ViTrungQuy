package Ex06.bussiness;

import Ex06.dao.AppointmentRepository;
import Ex06.entity.Appointments;

import java.util.ArrayList;

public class AppointmentBusiness {
    private AppointmentRepository repository;

    public AppointmentBusiness() {
        repository = new AppointmentRepository();
    }

    public ArrayList<Appointments> getAllAppointments() {
        return repository.getAllAppointments();
    }

    public Appointments getAppointmentById(int id) {
        return repository.getAppointmentById(id);
    }

    public void addAppointment(Appointments appointment) {
        repository.addAppointment(appointment);
    }

    public void updateAppointment(Appointments appointment) {
        repository.updateAppointment(appointment);
    }

    public void deleteAppointment(int id) {
        repository.deleteAppointment(id);
    }
}