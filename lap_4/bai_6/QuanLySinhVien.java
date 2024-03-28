import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class QuanLySinhVien {
    private static Scanner scanner = new Scanner(System.in);

    Vector<SinhVien> danhSachSV = new Vector<>();

    public void NhapDSSV() {
        System.out.print("Nhap so luong sinh vien trong danh sach: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.Nhap();
            danhSachSV.add(sv);
        }
        System.out.println();
    }

    // a) hien thi danh sach sinh vien theo diem tb giam
    public void dsSinhVienTheoDiemTBGiam() {
        Collections.sort(danhSachSV, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                if (sv1.getDiemTB() == sv2.getDiemTB()) {
                    return Double.compare(sv2.getDiemRL(), sv1.getDiemRL());
                }
                return Double.compare(sv2.getDiemTB(), sv1.getDiemTB());
            }
        });
        System.out.println("Danh sach sinh vien theo diem trung binh giam dan:");
        for (SinhVien sv : danhSachSV) {
            sv.Xuat();
        }
    }

    // b) Xoa nhung sinh vien co diem TB < 5 hoac diem ren luyen < 50
    public void XoaSVCoDiemKhongDatYeuCau() {
        Iterator<SinhVien> iterator = danhSachSV.iterator();
        while (iterator.hasNext()) {
            SinhVien sv = iterator.next();
            if (sv.getDiemTB() < 5 || sv.getDiemRL() < 50) {
                iterator.remove();
            }
        }
        System.out.println("Danh sach sinh vien sau khi xoa:");
        for (SinhVien sv : danhSachSV) {
            sv.Xuat();
        }
    }

    // c) them danh sach sinh vien moi tai K va xuat ra so luong sinh vien loai gioi
    public void NhapDSSVTaiK() {
        System.out.print("Nhap so luong sinh vien can chen: ");
        int m = scanner.nextInt();
        System.out.print("Nhap vi tri k (0 <= k <= " + danhSachSV.size() + "): ");
        int k = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + " can chen:");
            SinhVien sv = new SinhVien();
            sv.Nhap();
            danhSachSV.add(k + i, sv);
        }
        System.out.println("Danh sach sinh vien sau khi chen:");
        for (SinhVien sinhVien : danhSachSV) {
            sinhVien.Xuat();
        }
    }

    public void SinhVienLoaiGioi() {
        int countGioi = 0;
        for (SinhVien sv : danhSachSV) {
            if (sv.getDiemTB() >= 8.0 && sv.getDiemRL() >= 80) {
                countGioi++;
            }
        }
        System.out.println("So luong sinh vien dat loai gioi: " + countGioi);
    }

}
