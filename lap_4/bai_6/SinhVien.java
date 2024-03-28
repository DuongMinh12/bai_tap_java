import java.util.Scanner;

public class SinhVien {
    private String mssv;
    private String name;
    private double diemTB;
    private double diemRL;
    private static Scanner scanner = new Scanner(System.in);

    public SinhVien() {
        this("", "", 0, 0);
    }

    public SinhVien(String mssv, String name, double diemTB, double diemRL) {
        this.mssv = mssv;
        this.name = name;
        this.diemTB = diemTB;
        this.diemRL = diemRL;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiemTB(double diemTB) {
        if (diemTB >= 0 && diemTB <= 100) {
            this.diemTB = diemTB;
        } else {
            System.out.println("Diem trung binh khong hop le.");
        }
    }

    public void setDiemRL(double diemRL) {
        if (diemRL >= 0 && diemRL <= 100) {
            this.diemRL = diemRL;
        } else {
            System.out.println("Diem ren luyen khong hop le.");
        }
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public double getDiemRL() {
        return diemRL;
    }

    // function

    public void Nhap() {
        System.out.print("Nhap vao ma so sinh vien: ");
        setMssv(scanner.nextLine());
        System.out.print("Nhap vao ho ten sinh vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao diem trung binh cua sinh vien: ");
        setDiemTB(scanner.nextDouble());
        System.out.print("Nhap vao diem ren luyen cua sinh vien: ");
        setDiemRL(scanner.nextDouble());
        scanner.nextLine();

    }

    public void Xuat() {
        System.out.println("Ma so sinh vien: " + getMssv());
        System.out.println("Ho ten sinh vien: " + getName());
        System.out.println("Diem trung binh cua sinh vien: " + getDiemTB());
        System.out.println("Diem ren luyen cua sinh vien: " + getDiemRL());
        System.out.println();
    }
}