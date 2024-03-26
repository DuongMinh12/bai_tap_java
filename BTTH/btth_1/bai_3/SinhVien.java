import java.util.Scanner;

public class SinhVien {
    private static Scanner scanner = new Scanner(System.in);
    private int id;
    private String name;
    private String addr;
    private int sdt;
    private double diemTB;

    // contructor
    public SinhVien() {
        this.id = 0;
        this.name = "";
        this.addr = "";
        this.sdt = 0;
        this.diemTB = 0;
    }

    public SinhVien(int id, String ten, String addr, int sdt, double diemTB) {
        this.id = id;
        this.name = ten;
        this.addr = addr;
        this.sdt = sdt;
        this.diemTB = diemTB;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddr() {
        return this.addr;
    }

    public int getSdt() {
        return this.sdt;
    }

    public double getDiemTB() {
        return this.diemTB;
    }

    // functon
    public void Nhap() {
        System.out.print("Nhap vao ID cua sinh vien: ");
        setID(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nhap vao ho ten sinh vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao sdt cua sinh vien: ");
        setSdt(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nhap vao dia chi cua sinh vien: ");
        setAddr(scanner.nextLine());
        System.out.print("Nhap vao diem tb cua sinh vien: ");
        setDiemTB(scanner.nextDouble());
        scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("ID cua sinh vien: " + getID());
        System.out.println("Ho ten sinh vien: " + getName());
        System.out.println("Sdt cua sinh vien: " + getSdt());
        System.out.println("Dia chi cua sinh vien: " + getAddr());
        System.out.println("Diem tb cua sinh vien: " + getDiemTB());
        System.out.println();
    }
}
