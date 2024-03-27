import java.util.Scanner;

public class NhanVien extends NhanSu {
    private static Scanner scanner = new Scanner(System.in);
    private String donVi;

    public NhanVien() {
        super();
        this.donVi = "";
    }

    public NhanVien(String ten, String date, double heso, String donVi) {
        super(ten, date, heso);
        this.donVi = donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getDonVi() {
        return this.donVi;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhap vao he so luong nhan vien: ");
        setDonVi(scanner.nextLine());
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("Don vi/Phong ban: " + getDonVi());
        System.out.println("Luong nhan vien: " + Luong());
        System.out.println();
    }

    @Override
    public double Luong() {
        return super.getHesoLuong() * 1200000;
    }

}
