package Bai1.presentation;

import Bai1.business.DoctorBusiness;
import java.util.Scanner;

public class MainExerciseSumary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoctorBusiness business = new DoctorBusiness();

        System.out.println("--- he thong dang nhap bac si ---");
        System.out.print("ma bac si: ");
        String code = sc.nextLine();
        System.out.print("mat khau: ");
        String pass = sc.nextLine();

        // goi tang business de xu ly logic dang nhap
        if (business.checkLogin(code, pass)) {
            System.out.println("dang nhap thanh cong!");
        } else {
            System.out.println("thong tin khong chinh xac hoac tan cong bi chan.");
        }
    }
}