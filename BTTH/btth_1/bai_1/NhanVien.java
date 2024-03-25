public class NhanVien extends Person {
    private double luongCB;
    private double heso;

    public NhanVien() {
        super("", 0, "");
        this.luongCB = 0;
        this.heso = 0;
    }

    public NhanVien(String ten, int tuoi, String diachi, double luongcb, double heso) {
        super(ten, tuoi, diachi);
        this.luongCB = luongcb;
        this.heso = heso;
    }

    public void setLuongcb(double luong) {
        this.luongCB = luong;
    }

    public void setHeso(double hs) {
        this.heso = hs;
    }

    public double setLuongcb() {
        return this.luongCB;
    }

    public double setHeso() {
        return this.heso;
    }

    public double tinhLuong() {
        return (this.luongCB * this.heso);
    }

}
