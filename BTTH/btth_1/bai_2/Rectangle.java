import java.util.Scanner;

public class Rectangle extends ShapeClass {
    private double chieuDai;
    private double chieuRong;
    private static Scanner scanner = new Scanner(System.in);

    // contructor
    public Rectangle() {
        this.chieuDai = 0;
        this.chieuRong = 0;
    }

    public Rectangle(double cd, double cr) {
        this.chieuDai = cd;
        this.chieuRong = cr;
    }

    public void setChieuDai(double cd) {
        this.chieuDai = cd;
    }

    public void setChieuRong(double cr) {
        this.chieuRong = cr;
    }

    public double getChieuDai() {
        return this.chieuDai;
    }

    public double getChieuRong() {
        return this.chieuRong;
    }

    // function
    public void Nhap() {
        System.out.print("Nhap vao chieu dai: ");
        setChieuDai(scanner.nextDouble());
        System.out.print("Nhap vao chieu rong: ");
        setChieuRong(scanner.nextDouble());
    }

    @Override
    double tinhDienTich() {
        return getChieuDai() * getChieuRong();
    }

    @Override
    String toStringFunction() {
        String str = "";
        str += "Dien tich hinh chu nhat la: ";
        str += tinhDienTich();
        return str;
    }

}
