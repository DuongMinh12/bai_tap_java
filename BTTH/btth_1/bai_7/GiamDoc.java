
import java.util.Scanner;

public class GiamDoc extends NhanSu {
    private static Scanner scanner = new Scanner(System.in);
    private double hesoCV;

    public GiamDoc() {
        super();
        this.hesoCV = 0;
    }

    public GiamDoc(String ten, String date, double heso, double hesoCV) {
        super(ten, date, heso);
        this.hesoCV = hesoCV;
    }

    public void setHesoCV(double hesoCV) {
        this.hesoCV = hesoCV;
    }

    public double getHesoCV() {
        return this.hesoCV;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhap vao he so chuc vu: ");
        setHesoCV(scanner.nextDouble());
        scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("He so chuc vu: " + getHesoCV());
        System.out.println("Luong giam doc: " + Luong());
        System.out.println();
    }

    @Override
    public double Luong() {
        return (super.getHesoLuong() + getHesoCV()) * 1200000;
    }

}
