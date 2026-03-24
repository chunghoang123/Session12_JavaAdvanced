package Bai2.dao;


import Bai2.database.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VitalDao {
    public boolean updateVitals(int patientId, double temp, int heart) {
        // sử dụng chữ thường cho câu lệnh sql
        String sql = "update vitals set temperature = ?, heart_rate = ? where patient_id = ?";

        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // sử dụng các phương thức set để tránh lỗi định dạng dấu chấm/phẩy
            pstmt.setDouble(1, temp);
            pstmt.setInt(2, heart);
            pstmt.setInt(3, patientId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}