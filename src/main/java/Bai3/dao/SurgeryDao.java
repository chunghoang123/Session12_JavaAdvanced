package Bai3.dao;


import Bai3.database.MyDatabase;
import Bai3.model.Surgery;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class SurgeryDao {
    public Surgery getSurgeryFee(int id) {
        String sql = "{call get_surgery_fee(?, ?)}";
        try (Connection conn = MyDatabase.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, id);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();

            // tạo đối tượng model và đổ dữ liệu vào
            Surgery sur = new Surgery();
            sur.setId(id);
            sur.setTotalCost(cstmt.getDouble(2));

            return sur;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}