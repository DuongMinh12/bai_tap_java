import java.util.Scanner;

public class Circle extends ShapeClass {
    private double r;
    private static Scanner scanner = new Scanner(System.in);

    // contructor
    public void setBanKinh(double bk) {
        this.r = bk;
    }

    public double getBanKinh() {
        return this.r;
    }

    // function

    public void Nhap() {
        System.out.print("Nhap vao ban kinh: ");
        setBanKinh(scanner.nextDouble());
    }

    @Override
    double tinhDienTich() {
        return Math.PI * getBanKinh() * getBanKinh();
    }

    @Override
    String toStringFunction() {
        String str = "";
        str += "Dien tich hinh tron la: ";
        str += tinhDienTich();
        return str;
    }
}
