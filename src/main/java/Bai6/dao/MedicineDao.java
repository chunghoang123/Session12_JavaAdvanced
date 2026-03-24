package Bai6.dao;

import Bai6.database.MyDatabase;
import Bai6.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDao {

    // 1. cap nhat kho thuoc (PreparedStatement)
    public boolean updateMedicineStock(int id, int addedQuantity) {
        String sql = "update medicines set stock = stock + ? where id = ?";
        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, addedQuantity);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // 2. tim kiem theo khoang gia (PreparedStatement)
    public List<Medicine> findByPriceRange(double min, double max) {
        List<Medicine> list = new ArrayList<>();
        String sql = "select * from medicines where price between ? and ?";
        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, min);
            pstmt.setDouble(2, max);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Medicine m = new Medicine();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setStock(rs.getInt("stock"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 3. tinh tong tien don thuoc (OUT Parameter)
    public double getPrescriptionTotal(int pId) {
        String sql = "{call calculate_prescription_total(?, ?)}";
        try (Connection conn = MyDatabase.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, pId);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            return cstmt.getDouble(2);
        } catch (SQLException e) {
            return 0;
        }
    }

    // 4. doanh thu theo ngay (IN/OUT Parameter)
    public double getDailyRevenue(String dateStr) {
        String sql = "{call get_daily_revenue(?, ?)}";
        try (Connection conn = MyDatabase.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setDate(1, Date.valueOf(dateStr)); // chuyen chuoi yyyy-MM-dd sang SQL Date
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            return cstmt.getDouble(2);
        } catch (SQLException e) {
            return 0;
        }
    }
}