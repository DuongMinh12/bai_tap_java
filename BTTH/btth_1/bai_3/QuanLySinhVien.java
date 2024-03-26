import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLySinhVien {
    private static Scanner scanner = new Scanner(System.in);
    ArrayList<SinhVien> listSV = new ArrayList<>();

    public void NhapDSSV() {
        System.out.print("Nhap vao so luong sinh vien trong danh sach: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap vao sinh vien thu %d: ", i + 1);
            System.out.println();
            SinhVien sinhVien = new SinhVien();
            sinhVien.Nhap();
            listSV.add(sinhVien);
        }
    }

    public void XuatDSSV() {
        System.out.println("Dabg sach sinh vien: ");
        for (SinhVien sinhVien : listSV) {
            sinhVien.Xuat();
        }
    }

    public void SapXep() {
        Collections.sort(listSV, Comparator.comparing(SinhVien::getDiemTB));
        System.out.println("Danh sach sinh vien sau khi sap xep: ");
        XuatDSSV();
    }

    public void searchSV() {
        boolean found = false;
        scanner.nextLine();
        System.out.println("Nhap ten sinh vien can tim: ");
        String ten = scanner.nextLine();
        System.out.println("Ket qua tim kiem: ");
        for (SinhVien sv : listSV) {
            if (sv.getName().equalsIgnoreCase(ten)) {
                found = true;
                sv.Xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien nay");
            System.out.println();
        }
    }

    public void TimSVhoLe() {
        boolean found = false;
        System.out.println("Cac sinh vien co ho la \"Le\": ");
        for (SinhVien sinhVien : listSV) {
            if (sinhVien.getName().startsWith("Le")) {
                found = true;
                sinhVien.Xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien nay");
            System.out.println();
        }

    }

}
