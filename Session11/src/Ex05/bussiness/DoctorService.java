package Ex05.bussiness;

import Ex05.dao.DoctorDAO;
import Ex05.entity.Doctor;

import java.util.ArrayList;

public class DoctorService {
    private DoctorDAO doctorDao=new DoctorDAO();
    public ArrayList<Doctor> getAllDoctor(){
       return  doctorDao.getAllDoctors();
    }

    public boolean addDoctor(Doctor doctor){
        return doctorDao.addDoctor(doctor);
    }

    public void countSpecial(){
        doctorDao.countSpecial();
    }
}
