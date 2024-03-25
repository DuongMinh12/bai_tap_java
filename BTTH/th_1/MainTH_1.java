import java.util.Scanner;

public class MainTH_1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // ArrayList<NhanVien> dsnv = new ArrayList<>();

        System.out.print("Nhap vao so luong nhan vien: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        NhanVien[] nv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap vao nhan vien thu [%d]: ", i + 1);
            System.out.println();
            System.out.print("Nhap vao ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Nhap vao so tuoi: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhap vao so dia chi: ");
            String address = scanner.nextLine();
            System.out.print("Nhap vao luong co ban: ");
            double luongcb = scanner.nextDouble();
            System.out.print("Nhap vao he so: ");
            double heso = scanner.nextDouble();
            scanner.nextLine();

            nv[i] = new NhanVien(name, age, address, luongcb, heso);
        }

        // tong luong:

        double tongluong = 0;
        double luongCN = 0;
        NhanVien nvLCN = null;

        for (NhanVien detailnv : nv) {
            tongluong += detailnv.tinhLuong();
            if (detailnv.tinhLuong() > luongCN) {
                luongCN = detailnv.tinhLuong();
                nvLCN = detailnv;
            }
        }

        System.out.println("Tong luong: " + tongluong);
        System.out.println();
        System.out.println("Thong tin nhan vien co luong cao nhat: ");
        nvLCN.in4();
    }

}
