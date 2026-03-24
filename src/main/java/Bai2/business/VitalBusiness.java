package Bai2.business;

import Bai2.dao.VitalDao;

public class VitalBusiness {
    private VitalDao vitalDao = new VitalDao();

    public boolean updateVitals(int id, double temp, int heart) {
        return vitalDao.updateVitals(id, temp, heart);
    }
}