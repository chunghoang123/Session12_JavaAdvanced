package Bai4.dao;


import Bai4.database.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import Bai4.model.LabResult;

public class LabResultDao {
    public void insertBulkResults(List<LabResult> list) {
        // 1. khoi tao cau lenh sql ben ngoai vong lap
        String sql = "insert into lab_results (patient_id, test_value) values (?, ?)";

        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // tat che do tu dong commit de tang toc (optional)
            conn.setAutoCommit(false);

            for (LabResult res : list) {
                // 2. nap tham so ben trong vong lap
                pstmt.setInt(1, res.getPatientId());
                pstmt.setDouble(2, res.getTestValue());

                // 3. thuc thi (hoac add vao batch)
                pstmt.executeUpdate();
            }

            conn.commit(); // xac nhan luu tat ca du lieu
            System.out.println("da nap xong " + list.size() + " ket qua.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}