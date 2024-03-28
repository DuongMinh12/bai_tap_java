import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien> {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private double diemTB;

    public SinhVien() {
        this.name = "";
        this.diemTB = 0;
    }

    public SinhVien(String ten, double diem) {
        this.name = ten;
        this.diemTB = diem;
    }

    public void setDiemTB(double diemTB) {
        if (diemTB >= 0 && diemTB <= 10) {
            this.diemTB = diemTB;
        } else {
            System.out.println("Diem trung binh khong hop le.");
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getDiemTB() {
        return this.diemTB;
    }

    public void Nhap() {
        System.out.print("Nhap vao ho ten sinh vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao diem trung binh: ");
        setDiemTB(scanner.nextDouble());
        scanner.nextLine();
    }

    @Override
    public String toString() {
        return "[" + getName() + "]" + "_" + getDiemTB();
    }

    @Override
    public int compareTo(SinhVien sv) {
        if (this.diemTB < sv.diemTB) {
            return -1;
        } else if (this.diemTB > sv.diemTB) {
            return 1;
        } else {
            return 0;
        }
    }

}
