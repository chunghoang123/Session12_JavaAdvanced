package Bai5.presentation;

import Bai5.business.InpatientBusiness;
import Bai5.model.Inpatient;
import java.util.Scanner;

public class HospitalMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InpatientBusiness biz = new InpatientBusiness();

        while (true) {
            System.out.println("\n--- he thong quan ly noi tru rikkei ---");
            System.out.println("1. danh sach benh nhan");
            System.out.println("2. tiep nhan benh nhan moi");
            System.out.println("3. xuat vien & tinh phi");
            System.out.println("4. thoat");
            System.out.print("chon chuc nang: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                for (Inpatient p : biz.listAll()) {
                    System.out.println(p.getPatientCode() + " | " + p.getFullName() + " | " + p.getAge() + " | " + p.getDepartment());
                }
            } else if (choice == 2) {
                Inpatient p = new Inpatient();
                System.out.print("ma bn: "); p.setPatientCode(sc.nextLine());
                System.out.print("ho ten: "); p.setFullName(sc.nextLine()); // nhap thoai mai L'Oreal
                System.out.print("tuoi: "); p.setAge(Integer.parseInt(sc.nextLine()));
                System.out.print("khoa: "); p.setDepartment(sc.nextLine());
                if (biz.register(p)) System.out.println("tiep nhan thanh cong!");
            } else if (choice == 3) {
                System.out.print("nhap ma bn can tinh phi: ");
                String code = sc.nextLine();
                double fee = biz.calculateFee(code);
                System.out.println("tong vien phi: " + fee + " VND");
            } else if (choice == 4) {
                break;
            }
        }
    }
}