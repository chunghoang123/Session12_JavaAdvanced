package Bai6.presentation;

import Bai6.business.MedicineBusiness;
import Bai6.model.Medicine;
import java.util.List;
import java.util.Scanner;

public class PharmacyMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedicineBusiness business = new MedicineBusiness();

        while (true) {
            System.out.println("\n--- he thong quan ly don thuoc va doanh thu ---");
            System.out.println("1. cap nhat kho thuoc (nhap them)");
            System.out.println("2. tim kiem thuoc theo khoang gia");
            System.out.println("3. tinh tong tien mot don thuoc (out parameter)");
            System.out.println("4. thong ke doanh thu theo ngay (in/out parameter)");
            System.out.println("5. thoat");
            System.out.print("moi ban chon (1-5): ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                System.out.print("nhap id thuoc: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("nhap so luong muon them: ");
                int amount = Integer.parseInt(sc.nextLine());

                if (business.restock(id, amount)) {
                    System.out.println("cap nhat kho thanh cong!");
                } else {
                    System.out.println("cap nhat that bai (kiem tra lai id)!");
                }

            } else if (choice == 2) {
                System.out.print("nhap gia thap nhat: ");
                double min = Double.parseDouble(sc.nextLine());
                System.out.print("nhap gia cao nhat: ");
                double max = Double.parseDouble(sc.nextLine());

                List<Medicine> list = business.searchByPrice(min, max);
                if (list != null && !list.isEmpty()) {
                    System.out.println("ket qua tim kiem:");
                    for (Medicine m : list) {
                        System.out.println("ID: " + m.getId() + " | Ten: " + m.getName() + " | Gia: " + m.getPrice() + " | Ton kho: " + m.getStock());
                    }
                } else {
                    System.out.println("khong tim thay thuoc trong khoang gia nay.");
                }

            } else if (choice == 3) {
                System.out.print("nhap id don thuoc (prescription id): ");
                int pId = Integer.parseInt(sc.nextLine());
                double total = business.calculateOrder(pId);
                System.out.println("tong tien don thuoc " + pId + " la: " + total + " VND");

            } else if (choice == 4) {
                System.out.print("nhap ngay can thong ke (yyyy-mm-dd): ");
                String date = sc.nextLine();
                double dailyRevenue = business.checkRevenue(date);
                System.out.println("doanh thu ngay " + date + " la: " + dailyRevenue + " VND");

            } else if (choice == 5) {
                System.out.println("tam biet!");
                break;
            } else {
                System.out.println("lua chon khong hop le!");
            }
        }
    }
}