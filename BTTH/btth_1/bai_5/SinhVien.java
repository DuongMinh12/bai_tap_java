import java.util.Scanner;

public class SinhVien implements Measurable {
    private static Scanner scanner = new Scanner(System.in);

    private String maSv;
    private String name;
    private double diemToan;
    private double diemLy;
    private double diemHoa;
    private double diemTB;

    // contructor

    public SinhVien() {
        this.maSv = "";
        this.name = "";
        this.diemToan = 0;
        this.diemLy = 0;
        this.diemHoa = 0;
    }

    public SinhVien(String maSv, String ten, double diemToan, double diemLy, double diemHoa) {
        this.maSv = maSv;
        this.name = ten;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public void setmaSv(String maSv) {
        this.maSv = maSv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setdiemToan(double diemToan) {
        if (diemToan >= 0 && diemToan <= 10) {
            this.diemToan = diemToan;
        } else {
            System.out.println("Diem toan khong hop le.");
        }
    }

    public void setdiemLy(double diemLy) {
        if (diemLy >= 0 && diemLy <= 10) {
            this.diemLy = diemLy;
        } else {
            System.out.println("Diem ly khong hop le.");
        }
    }

    public void setdiemHoa(double diemHoa) {
        if (diemHoa >= 0 && diemHoa <= 10) {
            this.diemHoa = diemHoa;
        } else {
            System.out.println("Diem hoa khong hop le.");
        }
    }

    public String getmaSv() {
        return this.maSv;
    }

    public String getName() {
        return this.name;
    }

    public double getdiemToan() {
        return this.diemToan;
    }

    public double getdiemLy() {
        return this.diemLy;
    }

    public double getdiemHoa() {
        return this.diemHoa;
    }

    public double getdiemTB() {
        this.diemTB = Valuate();
        return this.diemTB;
    }

    public void Nhap() {
        System.out.print("Nhap vao ma sinh vien: ");
        setmaSv(scanner.nextLine());
        System.out.print("Nhap vao ho ten sinh vien: ");
        setName(scanner.nextLine());
        System.out.print("Nhap vao diem toan: ");
        setdiemToan(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Nhap vao diem ly: ");
        setdiemLy(scanner.nextDouble());
        System.out.print("Nhap vao diem hoa: ");
        setdiemHoa(scanner.nextDouble());
        scanner.nextLine();
    }

    public void Xuat() {
        System.out.println("Ma sinh vien: " + getmaSv());
        System.out.println("Ho ten: " + getName());
        System.out.println("Diem toan: " + getdiemToan());
        System.out.println("Diem ly: " + getdiemLy());
        System.out.println("Diem hoa: " + getdiemHoa());
        System.out.println("Diem trung binh: " + getdiemTB());
    }

    @Override
    public double Valuate() {
        return (getdiemToan() + getdiemLy() + getdiemHoa()) / 3;
    }

}
