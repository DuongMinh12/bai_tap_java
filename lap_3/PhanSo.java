import java.util.Scanner;

public class PhanSo implements SoSanhDuoc<PhanSo> {
    private int tu;
    private int mau;
    private static Scanner scanner = new Scanner(System.in);

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int t, int m) {
        this.tu = t;
        this.mau = m;
    }

    public void setTu(int t) {
        this.tu = t;
    }

    public void setMau(int m) {
        // if (m == 0) {
        // System.out.println("Mau so khong duoc bang khong. Vui long nhap lai mau so:
        // ");

        // } else {
        // this.mau = m;
        // }
        while (m == 0) {
            System.out.println("Mau so khong duoc bang khong. Vui long nhap lai mau so: ");
            m = scanner.nextInt();
        }
        this.mau = m;
    }

    public int getTu() {
        return this.tu;
    }

    public int getMau() {
        return this.mau;
    }

    public void nhap() {
        System.out.print("Nhap vao tu so: ");
        setTu(scanner.nextInt());
        System.out.print("Nhap vao mau so: ");
        setMau(scanner.nextInt());
    }

    public void xuat() {
        if (this.mau < 0) {
            System.out.println((this.tu * (-1) + "/" + (this.mau * (-1))));
        } else {
            System.out.println(this.tu + "/" + this.mau);
        }
    }

    @Override
    public int soSanh(PhanSo b) {
        if (b == null) {
            return 0;
        } else {
            double value1 = (double) this.getTu() / this.getMau();
            double value2 = (double) b.getTu() / b.getMau();
            if (value1 < value2) {
                return -1;
            } else if (value1 == value2) {
                return 0;
            } else {
                return 1;
            }
        }

    }

}
