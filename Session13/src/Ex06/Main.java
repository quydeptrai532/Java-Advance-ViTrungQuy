package Ex06;

import Ex06.dao.HospitalDAO;

public class Main {
    public static void main(String[] args) {
        HospitalDAO dao = new HospitalDAO();

        // Test Case 1: Thành công
        dao.xuatVien(101, 500000);

        // Test Case 2: Lỗi (sửa SQL trong DAO để test rollback)
        // ví dụ đổi BEDS -> BEDZZZ
    }
}