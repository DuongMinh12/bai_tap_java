
import java.util.Scanner;

public class QuanLy extends NhanSu {
    private static Scanner scanner = new Scanner(System.in);
    private double luongNVQL;

    public QuanLy() {
        super();
        this.luongNVQL = 0;
    }

    public QuanLy(String ten, String date, double heso, double luongNVQL) {
        super(ten, date, heso);
        this.luongNVQL = luongNVQL;
    }

    public void setLuongNVQL(double luongNVQL) {
        this.luongNVQL = luongNVQL;
    }

    public double getLuongNVQL() {
        return this.luongNVQL;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhap vao he so luong nhan vien quan ly: ");
        setLuongNVQL(scanner.nextDouble());
        scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("He so chuc vu: " + getLuongNVQL());
        System.out.println("Luong nhan vien quan ly: " + Luong());
        System.out.println();
    }

    @Override
    public double Luong() {
        return (super.getHesoLuong() + getLuongNVQL()) * 1200000;
    }

}
