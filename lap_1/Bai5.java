import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai5 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Integer> daySo = new ArrayList<>();

    public static void main(String[] args) {
        boolean continute = true;
        while (continute) {
            System.out.println("1. Nhap day so.");
            System.out.println("2. Xuat day so vua nhap.");
            System.out.println("3. Them gia tri vao day so.");
            System.out.println("4. Sua gia tri trong day so.");
            System.out.println("5. Xoa gia tri trong day so.");
            System.out.println("6. Sap xep day so tang dan.");
            System.out.println("7. Tinh gia tri trung binh va cho biet phan tu gan voi gia tri trung binh nhat.");
            System.out.println("8. Thoat.");
            System.out.print("Nhap lua chon cua ban: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Bai5.Nhap();
                    break;
                case 2:
                    Bai5.Xuat();
                    break;
                case 3:
                    Bai5.Them();
                    break;
                case 4:
                    Bai5.Sua();
                    break;
                case 5:
                    Bai5.Xoa();
                    break;
                case 6:
                    Bai5.SapXepTang();
                    break;
                case 7:
                    Bai5.TinhGiaTriTB();
                    break;
                case 8:
                    continute = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Chuc nang khong hop le, vui long chon lai");
                    break;
            }
        }
    }

    private static void Nhap() {
        System.out.print("Nhap so luong gia tri trong mang: ");
        int n = scanner.nextInt();
        System.out.print("Nhap cac gia tri cua mang: ");
        for (int i = 0; i < n; i++) {
            int so = scanner.nextInt();
            daySo.add(so);
        }
        System.out.println("Yeu cau cua ban da duoc thuc hien, vui long chon 2 de kiem tra.");
        System.out.println();
    }

    private static void Xuat() {
        System.out.print("Day so: ");
        for (int so : daySo) {
            System.out.print(so + " ");
        }
        System.out.println();
    }

    private static void Them() {
        System.out.print("Nhap so luong phan tu muon them: ");
        int n = scanner.nextInt();
        System.out.print("Nhap gia tri muon them vao mang: ");
        for (int i = 0; i < n; i++) {
            int soThem = scanner.nextInt();
            daySo.add(soThem);
        }
        Xuat();
    }

    private static void Sua() {
        System.out.print("Nhap so can sua: ");
        int soCanSua = scanner.nextInt();
        for (int i = 0; i < daySo.size(); i++) {
            if (daySo.get(i) == soCanSua) {
                System.out.print("Nhap so muon sua: ");
                int soNew = scanner.nextInt();
                daySo.set(i, soNew);
                Xuat();
                break;
            } else {
                System.out.println("Khong tim thay ket qua, vui long kiem tra lai.");
            }
        }
    }

    private static void Xoa() {
        System.out.print("Nhap so can xoa: ");
        int soCanXoa = scanner.nextInt();
        for (int i = 0; i < daySo.size(); i++) {
            if (daySo.get(i) == soCanXoa) {
                daySo.remove(i);
                Xuat();
                break;
            } else {
                System.out.println("Khong tim thay ket qua, vui long kiem tra lai.");
            }
        }
    }

    private static void SapXepTang() {
        Collections.sort(daySo);
        Xuat();
    }

    private static void TinhGiaTriTB() {
        if (daySo.isEmpty()) {
            System.out.println("Hien tai khong co gia tri nao trong mang.");
        } else{
            int tong = 0;
            for (int so : daySo) {
                tong += so;
            }
            double trungBinh = (double) tong / daySo.size();
            System.out.println("Gia tri trung binh cua mang tren la: " + trungBinh);
        }
        System.out.println();
    }

}
