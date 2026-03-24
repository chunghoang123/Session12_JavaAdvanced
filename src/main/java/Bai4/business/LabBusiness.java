package Bai4.business;


import Bai4.dao.LabResultDao;
import Bai4.model.LabResult;
import java.util.List;

public class LabBusiness {
    private LabResultDao labResultDao = new LabResultDao();

    public void importResults(List<LabResult> results) {
        // kiểm tra logic nghiệp vụ cơ bản
        if (results == null || results.isEmpty()) {
            System.out.println("khong co du lieu de nap.");
            return;
        }

        // gọi tầng dao để thực hiện nạp hàng loạt (bulk insert)
        labResultDao.insertBulkResults(results);
    }
}