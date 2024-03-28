// import java.util.ArrayList;
// import java.util.Scanner;

public class Main_btth1_7 {
    // private static Scanner scanner = new Scanner(System.in);
    // private static ArrayList<NhanVien> listNV = new ArrayList<>();
    // private static ArrayList<QuanLy> listQL = new ArrayList<>();
    // private static ArrayList<GiamDoc> listGD = new ArrayList<>();

    public static void main(String[] args) {
        QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
        quanLyNhanSu.NhapDS();
        quanLyNhanSu.XuatDS();
        quanLyNhanSu.nhanVienLuongMax();
        quanLyNhanSu.nhanVienSinhT2();
        quanLyNhanSu.nhanVienKeToan();
        quanLyNhanSu.SLNVTenAn();
    }
}
