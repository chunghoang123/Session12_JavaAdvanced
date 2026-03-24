package Bai3.presentation;

import Bai3.business.SurgeryBusiness;
import Bai3.model.Surgery;
import java.util.Scanner;

public class SurgeryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SurgeryBusiness business = new SurgeryBusiness();

        System.out.println("--- tra cuu chi phi phau thuat ---");
        System.out.print("nhap ma phau thuat (id): ");
        int id = Integer.parseInt(sc.nextLine());

        // total lúc này là một đối tượng Surgery
        Surgery surgeryResult = business.calculateFee(id);

        // 1. kiểm tra xem đối tượng có null không
        if (surgeryResult != null && surgeryResult.getTotalCost() > 0) {
            System.out.println("tong chi phi la: " + surgeryResult.getTotalCost() + " VND");
        } else {
            System.out.println("khong tim thay thong tin.");
        }
    }
}