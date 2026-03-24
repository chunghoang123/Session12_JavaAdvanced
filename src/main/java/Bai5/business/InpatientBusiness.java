package Bai5.business;

import Bai5.dao.InpatientDao;
import Bai5.model.Inpatient;

import java.util.List;

public class InpatientBusiness {
    private InpatientDao dao = new InpatientDao();

    public List<Inpatient> listAll() {
        return dao.getAll();
    }

    public boolean register(Inpatient p) {
        return dao.addPatient(p);
    }

    public double calculateFee(String code) {
        return dao.getDischargeFee(code);
    }
}