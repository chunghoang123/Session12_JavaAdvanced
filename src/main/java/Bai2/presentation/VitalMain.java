package Bai2.presentation;


import Bai2.business.VitalBusiness;
import java.util.Scanner;

public class VitalMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VitalBusiness business = new VitalBusiness();

        System.out.println("--- cap nhat chi so sinh ton ---");
        System.out.print("ma benh nhan: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("nhiet do: ");
        double temp = Double.parseDouble(sc.nextLine());

        System.out.print("nhip tim: ");
        int heart = Integer.parseInt(sc.nextLine());

        if (business.updateVitals(id, temp, heart)) {
            System.out.println("cap nhat thanh cong!");
        } else {
            System.out.println("cap nhat that bai.");
        }
    }
}