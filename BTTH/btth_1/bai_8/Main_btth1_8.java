import java.util.Scanner;
import java.util.Arrays;

public class Main_btth1_8 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhap vao so luong sinh vien trong danh sach: ");
        int n = scanner.nextInt();
        SinhVien[] dsSinhVien = new SinhVien[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            // SinhVien sinhVien = new SinhVien();
            dsSinhVien[i] = new SinhVien();
            dsSinhVien[i].Nhap();
        }
        System.out.println();

        // xuat
        System.out.println("Danh sach sinh vien:");
        for (int i = 0; i < dsSinhVien.length; i++) {
            System.out.printf("Sinh vien thu [%d]: ", i + 1);
            System.out.println(dsSinhVien[i].toString());
        }
        System.out.println();

        // sap xep
        Arrays.sort(dsSinhVien);

        System.out.println("Danh sach sinh vien co diem trung binh tang dan:");
        System.out.println(Arrays.toString(dsSinhVien));
    }
}
