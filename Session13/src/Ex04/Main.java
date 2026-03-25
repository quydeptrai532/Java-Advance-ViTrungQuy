package Ex04;

import Ex04.dao.HospitalDAO;

public class Main {
    public static void main(String[] args) {
        HospitalDAO dao = new HospitalDAO();

        dao.xuatVienVaThanhToan(1, 500000);
    }
}