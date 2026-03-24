package Bai4.presentation;


import Bai4.dao.LabResultDao;
import Bai4.model.LabResult;
import java.util.ArrayList;
import java.util.List;

public class LabMain {
    public static void main(String[] args) {
        LabResultDao dao = new LabResultDao();
        List<LabResult> dataList = new ArrayList<>();

        // gia lap 1.000 du lieu tu may phan tich
        for (int i = 1; i <= 1000; i++) {
            LabResult item = new LabResult();
            item.setPatientId(i);
            item.setTestValue(Math.random() * 10);
            dataList.add(item);
        }

        System.out.println("bat dau nap du lieu...");
        long start = System.currentTimeMillis();

        dao.insertBulkResults(dataList);

        long end = System.currentTimeMillis();
        System.out.println("thoi gian thuc hien: " + (end - start) + " ms");
    }
}