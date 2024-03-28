public class SinhVien {
    String mssv;
    String hoTen;
    double diemTB;
    double diemRL;

    public SinhVien(String mssv, String hoTen, double diemTB, double diemRL) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.diemRL = diemRL;
    }

    public String Xuat() {
        return mssv + " - " + hoTen + " - ĐTB: " + diemTB + " - ĐRL: " + diemRL;
    }
}