package Bai1.dao;

import Bai1.database.MyDatabase;
import Bai1.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDao {
    public Doctor login(String code, String pass) {
        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from doctors where code = ? and pass = ?")
        ) {
            // dữ liệu được truyền vào dưới dạng tham số thuần túy
            // giúp vô hiệu hóa các chuỗi độc hại như ' or '1'='1
            pstmt.setString(1, code);
            pstmt.setString(2, pass);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Doctor doc = new Doctor();
                    doc.setCode(rs.getString("code"));
                    doc.setName(rs.getString("name"));
                    return doc;

                }

            }


        } catch (Exception e) {
            e.printStackTrace();


        }
        return null;
    }
}
