package bai_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhanSo {
    private static Scanner scanner = new Scanner(System.in);

    // ------------Function----------------

    private static ArrayList<PhanSo> dayPhanSo = new ArrayList<>();
    private int tu;
    private int mau;

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
        this.mau = m;
    }

    public int getTu() {
        return this.tu;
    }

    public int getMau() {
        return this.mau;
    }

    public void nhap() {
        System.out.print("Nhap tu: ");
        setTu(scanner.nextInt());
        System.out.print("Nhap mau: ");
        setMau(scanner.nextInt());
        while (this.mau == 0) {
            System.out.print(" mau khong duoc bang khong, vui long nhap lai mau: ");
            setMau(scanner.nextInt());
        }
    }

    public void xuat() {
        System.out.println(this.tu + "/" + this.mau);
    }

    private int UCLN(int x, int y) {
        if (y == 0) {
            return x;
        }
        return UCLN(y, x % y);
    }

    public void rutGon() {
        int ucln = UCLN(tu, mau);
        this.tu /= ucln;
        this.mau /= ucln;
    }

    public PhanSo cong(PhanSo ps2) {
        PhanSo tong = new PhanSo();
        tong.tu = this.tu * ps2.mau + this.mau * ps2.tu;
        tong.mau = this.mau * ps2.mau;
        tong.rutGon();
        // System.out.println("Phan so tong:");
        // tong.xuat();
        return tong;
    }

    public PhanSo tru(PhanSo ps2) {
        PhanSo hieu = new PhanSo();
        hieu.tu = this.tu * ps2.mau - this.mau * ps2.tu;
        hieu.mau = this.mau * ps2.mau;
        hieu.rutGon();
        // System.out.println("Phan so hieu:");
        // hieu.xuat();
        return hieu;
    }

    public PhanSo nhanPS(PhanSo ps2) {
        PhanSo tich = new PhanSo();
        tich.tu = this.tu * ps2.tu;
        tich.mau = this.mau * ps2.mau;
        tich.rutGon();
        // System.out.println("Phan so tich:");
        // tich.xuat();
        return tich;
    }

    public PhanSo chiaPS(PhanSo ps2) {
        PhanSo thuong = new PhanSo();
        thuong.tu = this.tu * ps2.mau;
        thuong.mau = this.mau * ps2.tu;
        thuong.rutGon();
        // System.out.println("Phan so thuong:");
        // thuong.xuat();
        return thuong;
    }

    public int soSanh(PhanSo ps2) {
        double value1 = (double) this.tu / this.mau;
        double value2 = (double) ps2.tu / ps2.mau;

        if (value1 < value2)
            return -1;
        else if (value1 > value2)
            return 1;
        else
            return 0;

    }

    // Day phan so

    public static void nhapDayPhanSo() {
        System.out.print("Nhap vao so luong phan so trong day: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan so thu " + (i + 1) + ": ");
            PhanSo ps = new PhanSo();
            ps.nhap();
            dayPhanSo.add(ps);
        }
    }

    public static void xuatDayPhanSo() {
        System.out.println("Day cac phan so: ");
        for (PhanSo ps : dayPhanSo) {
            ps.xuat();
        }
        System.out.println();
    }

    public static void tongCacPhanSo() {
        PhanSo tongps = new PhanSo();
        for (PhanSo ps : dayPhanSo) {
            tongps = tongps.cong(ps);
        }
        System.out.print("Tong cac phan so la: ");
        tongps.xuat();
        System.out.println();
    }

    public static void soSanhCacPhanSo() {
        // Arrays.sort(dayPhanSo, (a, b) -> a.soSanh(b));
        PhanSo[] mangPhanSo = dayPhanSo.toArray(new PhanSo[0]);
        Arrays.sort(mangPhanSo, (a, b) -> a.soSanh(b));
        System.out.println("Danh sach phan so sau khi sap xep:");
        for (PhanSo ps : mangPhanSo) {
            ps.xuat();
        }
    }
}
