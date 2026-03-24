package Bai6.business;

import Bai6.dao.MedicineDao;
import Bai6.model.Medicine;

import java.util.List;

public class MedicineBusiness {
    private MedicineDao medicineDao = new MedicineDao();

    // 1. Logic cap nhat kho
    public boolean restock(int id, int amount) {
        if (amount <= 0) {
            System.out.println("so luong them vao phai lon hon 0!");
            return false;
        }
        return medicineDao.updateMedicineStock(id, amount);
    }

    // 2. Logic tim kiem theo gia
    public List<Medicine> searchByPrice(double min, double max) {
        if (min > max) {
            System.out.println("gia thap nhat khong duoc lon hon gia cao nhat!");
            return null;
        }
        return medicineDao.findByPriceRange(min, max);
    }

    // 3. Logic tinh tong don thuoc
    public double calculateOrder(int pId) {
        return medicineDao.getPrescriptionTotal(pId);
    }

    // 4. Logic doanh thu ngay
    public double checkRevenue(String dateStr) {
        // co the kiem tra dinh dang ngay yyyy-MM-dd tai day
        return medicineDao.getDailyRevenue(dateStr);
    }
}