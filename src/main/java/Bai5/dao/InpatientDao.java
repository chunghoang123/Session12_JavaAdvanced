package Bai5.dao;

import Bai5.database.MyDatabase;
import Bai5.model.Inpatient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InpatientDao {
    // 1. lay danh sach
    public List<Inpatient> getAll() {
        List<Inpatient> list = new ArrayList<>();
        String sql = "select * from inpatients";
        try (Connection conn = MyDatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Inpatient p = new Inpatient();
                p.setPatientCode(rs.getString("patient_code"));
                p.setFullName(rs.getString("full_name"));
                p.setAge(rs.getInt("age"));
                p.setDepartment(rs.getString("department"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // 2. tiep nhan moi (PreparedStatement tu dong xu ly dau nhay don ')
    public boolean addPatient(Inpatient p) {
        String sql = "insert into inpatients (patient_code, full_name, age, department) values (?, ?, ?, ?)";
        try (Connection conn = MyDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getPatientCode());
            pstmt.setString(2, p.getFullName());
            pstmt.setInt(3, p.getAge());
            pstmt.setString(4, p.getDepartment());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }

    // 3. tinh phi xuat vien
    public double getDischargeFee(String code) {
        String sql = "{call calculate_discharge_fee(?, ?)}";
        try (Connection conn = MyDatabase.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, code);
            cstmt.registerOutParameter(2, Types.DECIMAL);
            cstmt.execute();
            return cstmt.getDouble(2);
        } catch (Exception e) { return -1; }
    }
}