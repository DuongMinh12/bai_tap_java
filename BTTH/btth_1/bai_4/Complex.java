import java.util.Scanner;

public class Complex {
    private double soThuc;
    private double soAo;
    private static Scanner scanner = new Scanner(System.in);

    // contruction

    public Complex() {
        this.soThuc = 0;
        this.soAo = 0;
    }

    public Complex(double st, double sa) {
        this.soThuc = st;
        this.soAo = sa;
    }

    public void setSoThuc(double a) {
        this.soThuc = a;
    }

    public void setSoAo(double b) {
        this.soAo = b;
    }

    public double getSoThuc() {
        return this.soThuc;
    }

    public double getSoAo() {
        return this.soAo;
    }

    // function

    public void Nhap() {
        System.out.print("Vui long nhap vao phan thuc: ");
        setSoThuc(scanner.nextDouble());
        System.out.print("Vui long nhap vao phan ao: ");
        setSoAo(scanner.nextDouble());
    }

    public void Xuat() {
        if (getSoAo() < 0) {
            System.out.println(getSoThuc() + " - " + Math.abs(getSoAo()) + "*i");
        } else {
            System.out.println(getSoThuc() + " + " + getSoAo() + "*i");
        }
        System.out.println();
    }

    public Complex cong(Complex b) {
        double thuc = getSoThuc() + b.getSoThuc();
        double ao = getSoAo() + b.getSoAo();
        return new Complex(thuc, ao);
    }

    public Complex tru(Complex b) {
        double thuc = getSoThuc() - b.getSoThuc();
        double ao = getSoAo() - b.getSoAo();
        return new Complex(thuc, ao);
    }

    public Complex nhan(Complex b) {
        double thuc = getSoThuc() * b.getSoThuc() - getSoAo() * b.getSoAo();
        double ao = getSoThuc() * b.getSoAo() + b.getSoThuc() * getSoAo();
        return new Complex(thuc, ao);

    }

    public Complex chia(Complex b) {
        double thuc = (getSoThuc() * b.getSoThuc() + getSoAo() * b.getSoAo())
                / (b.getSoThuc() * b.getSoThuc() + b.getSoAo() * b.getSoAo());

        double ao = (b.getSoThuc() * getSoAo() - getSoThuc() * b.getSoAo())
                / (b.getSoThuc() * b.getSoThuc() + b.getSoAo() * b.getSoAo());

        return new Complex(thuc, ao);
    }
}
