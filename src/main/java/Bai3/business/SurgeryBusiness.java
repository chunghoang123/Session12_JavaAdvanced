package Bai3.business;


import  Bai3.dao.SurgeryDao;
import Bai3.model.Surgery;

public class SurgeryBusiness {
    private SurgeryDao surgeryDao = new SurgeryDao();

    public Surgery calculateFee(int id) {
        return surgeryDao.getSurgeryFee(id);
    }
}