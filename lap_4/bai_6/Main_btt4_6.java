public class Main_btt4_6 {
    public static void main(String[] args) {
        QuanLySinhVien quanLySV = new QuanLySinhVien();

        quanLySV.NhapDSSV();
        // a) hien thi danh sach sinh vien theo diem tb giam
        quanLySV.dsSinhVienTheoDiemTBGiam();

        // b) Xoa nhung sinh vien co diem TB < 5 hoac diem ren luyen < 50
        quanLySV.XoaSVCoDiemKhongDatYeuCau();

        // c) them danh sach sinh vien moi tai K va xuat ra so luong sinh vien loai gioi
        quanLySV.NhapDSSVTaiK();
        quanLySV.SinhVienLoaiGioi();
    }
}
