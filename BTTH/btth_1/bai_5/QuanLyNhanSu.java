import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanSu {
    private static Scanner scanner = new Scanner(System.in);
    ArrayList<NhanVien> listNhanVien = new ArrayList<>();
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    private double luongTB = 0;
    private double diemTB = 0;

    public double getdiemTB() {
        this.diemTB = TinhDiemTB();
        return this.diemTB;
    }

    public double getluongTB() {
        this.luongTB = TinhLuongTB();
        return this.luongTB;
    }

    public void NhapDanhSach() {
        System.out.print("Nhap vao so luong nguoi: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Chon nguoi ban muon nhap: ");
            System.out.println("1. Nhan Vien.");
            System.out.println("2. Sinh Vien.");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.Nhap();
                    listNhanVien.add(nhanVien);
                    break;
                case 2:
                    SinhVien sinhVien = new SinhVien();
                    sinhVien.Nhap();
                    listSinhVien.add(sinhVien);
                    break;
                default:
                    System.out.println("Lua chon nay khong ton tai, vui long chon lai.");
                    System.out.println();
                    i--;
                    break;
            }
        }
    }

    // public void NhapDSNhanVien() {
    // }

    public void XuatDanhSach() {
        System.out.println("Danh sach nhan vien: ");
        for (NhanVien nv : listNhanVien) {
            nv.Xuat();
        }
        System.out.println();
        System.out.println("Danh sach sinh vien: ");
        for (SinhVien sv : listSinhVien) {
            sv.Xuat();
        }
        System.out.println();
    }

    public double TinhDiemTB() {
        double tongDiem = 0;
        for (SinhVien sv : listSinhVien) {
            tongDiem += sv.Valuate();
        }
        return tongDiem / listSinhVien.size();
    }

    public double TinhLuongTB() {
        double tongLuong = 0;
        for (NhanVien nv : listNhanVien) {
            tongLuong += nv.Valuate();
        }
        return tongLuong / listNhanVien.size();
    }

    // public void XuatDSNhanVien() {
    // }

}
