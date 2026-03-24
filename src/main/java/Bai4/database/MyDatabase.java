package Bai4.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDatabase {
    private  static final String url = "jdbc:mysql://localhost:3306/rikkeicaredb_2";
    private  static final String user = "root";
    private  static final String password = "Londeocan1";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi database thanh cong.");
            return conn;

        }catch (Exception e){
            System.out.println("Loi ket noi database." + e.getMessage());
        }
        return null;
    }
}
