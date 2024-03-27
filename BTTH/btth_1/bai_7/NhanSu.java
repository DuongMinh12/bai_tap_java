import java.util.Scanner;

abstract class NhanSu {
    private static Scanner scanner = new Scanner(System.in);
    protected String name;
    protected String ngaysinh;
    protected double hesoLuong;

    public NhanSu() {
        this.name = "";
        this.ngaysinh = "";
        this.hesoLuong = 0;
    }

    public NhanSu(String name, String ngaySinh, double hesoLuong) {
        this.name = name;
        this.ngaysinh = ngaySinh;
        this.hesoLuong = hesoLuong;
    }

    public void setName(String ten) {
        this.name = ten;
    }

    public void setNgaySinh(String date) {
        this.ngaysinh = date;
    }

    public void setHesoLuong(double hesoLuong) {
        this.hesoLuong = hesoLuong;
    }

    public String getName() {
        return this.name;
    }

    public String getNgaySinh() {
        return this.ngaysinh;
    }

    public double getHesoLuong() {
        return this.hesoLuong;
    }

    public void Nhap() {
        System.out.print("Nhap vao ho ten nhan vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao ngay sinh (theo dinh dang dd/mm/yy): ");
        setNgaySinh(scanner.nextLine());
        System.out.print("Nhap vao he so luong: ");
        setHesoLuong(scanner.nextDouble());
        scanner.nextLine();
    };

    public void Xuat() {
        System.out.println("Ho ten: A" + getName());
        System.out.println("Ngay sinh: " + getNgaySinh());
        System.out.println("He so luong" + getName());
    }

    public abstract double Luong();
}
