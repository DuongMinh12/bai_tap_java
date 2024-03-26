import java.util.Scanner;

public class Main_btth1_3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuteProgram = true;
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        while (continuteProgram) {
            System.out.println("Chon mot trong cac lua chon sau: ");
            System.out.println("1. Nhap vao danh sach sinh vien.");
            System.out.println("2. Xuat ra danh sach sinh vien.");
            System.out.println("3. Sap xep sinh vien theo diem tb tang dan.");
            System.out.println("4. Tim sinh vien.");
            System.out.println("5. Tim sinh vien ho \"Le\".");
            System.out.println("6. Thoat chuong trinh.");
            int option = scanner.nextInt();
            // scanner.nextLine();
            switch (option) {
                case 1:
                    quanLySinhVien.NhapDSSV();
                    break;
                case 2:
                    quanLySinhVien.XuatDSSV();
                    break;
                case 3:
                    quanLySinhVien.SapXep();
                    break;
                case 4:
                    quanLySinhVien.searchSV();
                    break;
                case 5:
                    quanLySinhVien.TimSVhoLe();
                    break;
                case 6:
                    System.out.println("Chuong trinh da thoat.");
                    continuteProgram = false;
                    break;
                default:
                    System.out.println("Lua chon nay khong ton tai, vui long nhap lai");
                    break;
            }
        }
    }
}
