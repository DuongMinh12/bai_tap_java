// import java.util.Scanner;

public class Main_btth1_5 {
    // private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
        quanLyNhanSu.NhapDanhSach();
        // quanLyNhanSu.XuatDanhSach();
        double luongTB = quanLyNhanSu.getluongTB();
        System.out.println("Luong trung binh cua nhan vien la: " + luongTB);
        double diemTb = quanLyNhanSu.getdiemTB();
        System.out.println("Diem trung binh cua sinh vien la: " + diemTb);
    }
}
