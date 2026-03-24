package Bai1.business;


import Bai1.dao.DoctorDao;
import Bai1.model.Doctor;

public class DoctorBusiness {
    // khởi tạo đối tượng dao để tương tác với database
    private DoctorDao doctorDao = new DoctorDao();

    public boolean checkLogin(String code, String pass) {
        // kiểm tra nghiệp vụ cơ bản trước khi truy vấn
        if (code == null || pass == null) {
            return false;
        }
        // gọi xuống tầng dao và trả về kết quả xác thực
        Doctor doc = doctorDao.login(code, pass);
        return doc != null;
    }
}