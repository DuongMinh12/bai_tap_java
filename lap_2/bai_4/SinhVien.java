package bai_4;

import java.util.*;

class SinhVien {
    String hoTen;
    String mssv;
    ArrayList<LopHoc> dangKy = new ArrayList<>();

    SinhVien(String hoTen, String mssv) {
        this.hoTen = hoTen;
        this.mssv = mssv;
    }

    void dangKyMon(LopHoc lop) {
        dangKy.add(lop);
    }

    void xuatThongTin() {
        System.out.println("Ho va ten: " + hoTen);
        System.out.println("MSSV: " + mssv);
    }
}
