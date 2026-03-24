package Bai1.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDatabase {
    private  static  final String url ="jdbc:mysql://localhost:3306/rikkeicaredb";
    private static final String username = "root";
    private static final String pass = "Londeocan1";

    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("ket noi thanh cong");
            return conn;


        }catch(Exception e){
            System.out.println("ket noi that bai"+e.getMessage());

        }
        return null;
    }
}
