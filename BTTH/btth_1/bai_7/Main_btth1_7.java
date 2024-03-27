import java.util.ArrayList;
import java.util.Scanner;

public class Main_btth1_7 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<NhanVien> listNV = new ArrayList<>();
    private static ArrayList<QuanLy> listQL = new ArrayList<>();
    private static ArrayList<GiamDoc> listGD = new ArrayList<>();

    public static void main(String[] args) {

    }

    // funtion

    public void NhapDS() {
        System.out.print("Nhap vao so nhan vien trong danh sach: ");
        int n = scanner.nextInt();
        // scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nhan su muon them vao trong danh sach: ");
            System.out.println("1. Nhan vien.");
            System.out.println("2. Quan ly.");
            System.out.println("3. Giam Doc.");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.Nhap();
                    listNV.add(nhanVien);
                    break;
                case 2:
                    QuanLy quanLy = new QuanLy();
                    quanLy.Nhap();
                    listQL.add(quanLy);
                    break;
                case 3:
                    GiamDoc giamDoc = new GiamDoc();
                    giamDoc.Nhap();
                    listGD.add(giamDoc);
                    break;
                default:
                    System.out.println("Khong co lua chon nay, vui long nhap lai.");
                    System.out.println();
                    i--;
                    break;
            }
        }
    }
}
