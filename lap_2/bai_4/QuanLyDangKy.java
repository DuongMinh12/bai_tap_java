package bai_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuanLyDangKy {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Nhập số lượng sinh viên và số lượng lớp học
        System.out.print("Nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        System.out.print("Nhap so luong lop hoc: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        // Khởi tạo danh sách sinh viên và lớp học
        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        ArrayList<LopHoc> danhSachLopHoc = new ArrayList<>();

        // Nhập thông tin sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            System.out.print("Ho va ten: ");
            String hoTen = scanner.nextLine();
            System.out.print("MSSV: ");
            String mssv = scanner.nextLine();
            SinhVien sv = new SinhVien(hoTen, mssv);
            danhSachSinhVien.add(sv);
        }

        // Nhập thông tin lớp học
        for (int i = 0; i < m; i++) {
            System.out.println("Nhap thong tin lop hoc thu " + (i + 1) + ":");
            System.out.print("Ma lop: ");
            String maLop = scanner.nextLine();
            System.out.print("Ten mon: ");
            String tenMon = scanner.nextLine();
            System.out.print("So tin chi: ");
            int soTinChi = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Thoi gian hoc: ");
            String thoiGianHoc = scanner.nextLine();
            System.out.print("Thoi gian bat dau: ");
            String thoiGianBatDau = scanner.nextLine();
            System.out.print("Thoi gian ket thuc: ");
            String thoiGianKetThuc = scanner.nextLine();
            LopHoc lop = new LopHoc(maLop, tenMon, soTinChi, thoiGianHoc, thoiGianBatDau, thoiGianKetThuc);
            danhSachLopHoc.add(lop);
        }

        // Đăng ký môn học cho sinh viên
        for (SinhVien sv : danhSachSinhVien) {
            System.out.println("Sinh vien " + sv.hoTen + " dang ky mon hoc:");
            for (LopHoc lop : danhSachLopHoc) {
                System.out.print("Ban co muon dang ky mon " + lop.tenMon + " (Y/N)? ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    sv.dangKyMon(lop);
                }
            }
        }

        // Tìm môn có nhiều sinh viên đăng ký nhất
        HashMap<LopHoc, Integer> countMonHoc = new HashMap<>();
        for (LopHoc lop : danhSachLopHoc) {
            countMonHoc.put(lop, 0);
        }
        for (SinhVien sv : danhSachSinhVien) {
            for (LopHoc lop : sv.dangKy) {
                countMonHoc.put(lop, countMonHoc.get(lop) + 1);
            }
        }
        int maxSvDangKy = 0;
        LopHoc monNhieuSvDangKy = null;
        for (Map.Entry<LopHoc, Integer> entry : countMonHoc.entrySet()) {
            if (entry.getValue() > maxSvDangKy) {
                maxSvDangKy = entry.getValue();
                monNhieuSvDangKy = entry.getKey();
            }
        }
        System.out.println("Mon co nhieu sinh vien dang ky nhat la " + monNhieuSvDangKy.tenMon + " voi " + maxSvDangKy
                + " sinh vien.");

        // Tìm sinh viên đăng ký nhiều môn nhất và nhiều tín chỉ nhất
        HashMap<SinhVien, Integer> countMonDangKy = new HashMap<>();
        HashMap<SinhVien, Integer> countTinChi = new HashMap<>();
        for (SinhVien sv : danhSachSinhVien) {
            countMonDangKy.put(sv, sv.dangKy.size());
            int sumTinChi = 0;
            for (LopHoc lop : sv.dangKy) {
                sumTinChi += lop.soTinChi;
            }
            countTinChi.put(sv, sumTinChi);
        }
        int maxMonDangKy = 0;
        int maxTinChi = 0;
        SinhVien svNhieuMonDangKy = null;
        SinhVien svNhieuTinChi = null;
        for (Map.Entry<SinhVien, Integer> entry : countMonDangKy.entrySet()) {
            if (entry.getValue() > maxMonDangKy) {
                maxMonDangKy = entry.getValue();
                svNhieuMonDangKy = entry.getKey();
            }
        }
        for (Map.Entry<SinhVien, Integer> entry : countTinChi.entrySet()) {
            if (entry.getValue() > maxTinChi) {
                maxTinChi = entry.getValue();
                svNhieuTinChi = entry.getKey();
            }
        }
        System.out.println(
                "Sinh vien dang ky nhieu mon nhat la " + svNhieuMonDangKy.hoTen + " voi " + maxMonDangKy + " mon.");
        System.out.println(
                "Sinh vien co nhieu tin chi nhat la " + svNhieuTinChi.hoTen + " voi " + maxTinChi + " tin chi.");

        // Nhập vào một mssv và xuất ra lịch học của sinh viên đó
        System.out.print("Nhap vao MSSV de xem lich hoc: ");
        String mssv = scanner.nextLine();
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.mssv.equals(mssv)) {
                System.out.println("Lich hoc cua sinh vien " + sv.hoTen + ":");
                for (LopHoc lop : sv.dangKy) {
                    System.out.println("Mon: " + lop.tenMon + ", Thoi gian hoc: " + lop.thoiGianHoc +
                            ", Thoi gian: " + lop.thoiGianBatDau + " - " + lop.thoiGianKetThuc);
                }
                break;
            }
        }
    }
}
