import java.util.Scanner;

public class NhanVien implements Measurable {
    private static Scanner scanner = new Scanner(System.in);

    private String maNv;
    private String name;
    private double gioLam;
    private double giaTheoGio;
    private double luong;

    // contructor

    public NhanVien() {
        this.maNv = "";
        this.name = "";
        this.gioLam = 0;
        this.giaTheoGio = 0;
    }

    public NhanVien(String manv, String ten, double giolam, double gia) {
        this.maNv = manv;
        this.name = ten;
        this.gioLam = giolam;
        this.giaTheoGio = gia;
    }

    public void setMaNV(String manv) {
        this.maNv = manv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGioLam(double gioLam) {
        this.gioLam = gioLam;
    }

    public void setGia(double giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }

    public String getMaNV() {
        return this.maNv;
    }

    public String getName() {
        return this.name;
    }

    public double getGioLam() {
        return this.gioLam;
    }

    public double getGia() {
        return this.giaTheoGio;
    }

    public double getLuong() {
        this.luong = Valuate();
        return this.luong;
    }

    public void Nhap() {
        System.out.print("Nhap vao ma nhan vien: ");
        setMaNV(scanner.nextLine());
        System.out.print("Nhap vao ho ten nhan vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao so gio lam: ");
        setGioLam(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Nhap vao gia theo gio: ");
        setGia(scanner.nextDouble());
        scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("Ma nhan vien: " + getMaNV());
        System.out.println("Ho ten: " + getName());
        System.out.println("So gio lam: " + getGioLam());
        System.out.println("Gia theo gio: " + getGia());
        System.out.println("Luong nhan vien: " + getLuong());
    }

    @Override
    public double Valuate() {
        return getGioLam() * getGia();
    }

}
