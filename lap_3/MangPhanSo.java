import java.util.Arrays;
import java.util.Scanner;

public class MangPhanSo implements SapXepDuoc<PhanSo> {
    private static Scanner scanner = new Scanner(System.in);

    public PhanSo[] nhapMangPS() {
        System.out.print("Nhap vao so luong phan tu trong mang: ");
        int n = scanner.nextInt();
        PhanSo[] ps = new PhanSo[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap vao phan tu thu %d: ", i);
            ps[i] = new PhanSo();
            ps[i].nhap();
        }
        return ps;
    }

    public void xuatMangPS(PhanSo[] arr) {
        System.out.println("Mang phan so: ");
        for (PhanSo ps : arr) {
            ps.xuat();
        }
        System.out.println();
    }

    @Override
    public void mangTangGiam(PhanSo[] ps) {
        System.out.println("Ban muon xuat ra mang tang hay giam?");
        System.out.println("1. Tang");
        System.out.println("2. Giam");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                Arrays.sort(ps, (a, b) -> a.soSanh(b));
                xuatMangPS(ps);
                break;
            case 2:
                Arrays.sort(ps, (a, b) -> b.soSanh(a));
                xuatMangPS(ps);
                break;
            default:
                System.out.println("Khong co lua chon nay.");
                break;
        }
    }

    @Override
    public void xuatPhanTu(PhanSo[] ps) {
        System.out.println("Ban muon xuat ra phan tu lon nhat hay nho nhat?");
        System.out.println("1. Lon nhat");
        System.out.println("2. Nho nhat");
        int option = scanner.nextInt();
        Arrays.sort(ps, (a, b) -> a.soSanh(b));
        switch (option) {
            case 1:
                System.out.print("Phan so lon nhat la: ");
                ps[ps.length - 1].xuat();
                System.out.println();
                break;
            case 2:
                System.out.print("Phan so nho nhat la: ");
                ps[0].xuat();
                System.out.println();
                break;
            default:
                System.out.println("Khong co lua chon nay.");
                break;
        }
    }
}
