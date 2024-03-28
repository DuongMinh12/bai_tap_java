import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNhanSu {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<NhanVien> listNV = new ArrayList<>();
    private static ArrayList<QuanLy> listQL = new ArrayList<>();
    private static ArrayList<GiamDoc> listGD = new ArrayList<>();

    public void NhapDS() {
        System.out.print("Nhap vao so nhan vien trong danh sach: ");
        int n = scanner.nextInt();
        // scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nhan su muon them vao trong danh sach: ");
            System.out.println("1. Nhan vien.");
            System.out.println("2. Quan ly.");
            System.out.println("3. Giam Doc.");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.Nhap();
                    listNV.add(nhanVien);
                    break;
                case 2:
                    QuanLy quanLy = new QuanLy();
                    quanLy.Nhap();
                    listQL.add(quanLy);
                    break;
                case 3:
                    GiamDoc giamDoc = new GiamDoc();
                    giamDoc.Nhap();
                    listGD.add(giamDoc);
                    break;
                default:
                    System.out.println("Khong co lua chon nay, vui long nhap lai.");
                    System.out.println();
                    i--;
                    break;
            }
        }
    }

    public void XuatDS() {
        System.out.println("Danh sach nhan su: ");
        if (listGD.size() > 0) {
            System.out.println("Danh sach giam doc: ");
            for (GiamDoc giamDoc : listGD) {
                giamDoc.Xuat();
            }
            System.out.println();
        }
        if (listQL.size() > 0) {
            System.out.println("Danh sach quan ly: ");
            for (QuanLy quanLy : listQL) {
                quanLy.Xuat();
            }
            System.out.println();
        }
        if (listNV.size() > 0) {
            System.out.println("Danh sach nhan vien: ");
            for (NhanVien nhanVien : listNV) {
                nhanVien.Xuat();
            }
            System.out.println();
        }

    }

    public void nhanVienLuongMax() {
        double luongmax = 0;
        NhanSu nhanVienLuongMax = new NhanVien();
        // GiamDoc giamDoc = new GiamDoc();
        // QuanLy quanLy = new QuanLy();
        if (listNV.size() > 0) {
            for (NhanVien nv : listNV) {
                if (nv.Luong() > luongmax) {
                    luongmax = nv.Luong();
                    nhanVienLuongMax = nv;
                }
            }
            // for (GiamDoc gd : listGD) {
            // if (gd.Luong() > luongmax) {
            // luongmax = gd.Luong();
            // nhanVienLuongMax = gd;
            // }
            // }
            System.out.println("Nhan vien co luong cao nhat la: ");
            nhanVienLuongMax.Xuat();
        } else {
            System.out.println("Khong co nhan vien de so sanh luong.");
        }

        // for (GiamDoc gd : listGD) {
        // if (gd.Luong() > luongmax) {
        // luongmax = gd.Luong();
        // nhanVienLuongMax = gd;
        // }
        // }
        // for (QuanLy ql : listQL) {
        // if (ql.Luong() > luongmax) {
        // luongmax = ql.Luong();
        // nhanVienLuongMax = ql;
        // }
        // }
    }

    public void nhanVienSinhT2() {
        boolean found = false;
        System.out.println("Cac sinh vien sinh trong thang 2 la:");
        for (NhanVien nv : listNV) {
            String ngaySinh = nv.getNgaySinh();
            String[] parts = ngaySinh.split("/");

            if (parts.length == 3 && parts[1].equals("02")) {
                nv.Xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien nao sinh trong thang 2.");
            System.out.println();
        }
    }

    public void nhanVienKeToan() {
        boolean found = false;
        System.out.println("Thong tin nhan vien thuoc phong \"Ke toan\":");
        for (NhanVien nv : listNV) {
            if (nv.getDonVi().equals("Ke toan")) {
                nv.Xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien nao thuoc phong \"ke toan\".");
        }
    }

    public void SLNVTenAn() {
        int dem = 0;
        for (NhanVien nv : listNV) {
            if (nv.getName().contains("An")) {
                dem++;
            }
        }
        for (QuanLy QL : listQL) {
            if (QL.getName().contains("An")) {
                dem++;
            }
        }
        for (GiamDoc GD : listGD) {
            if (GD.getName().contains("An")) {
                dem++;
            }
        }

        System.out.println("So luong nhan vien co ten An la: " + dem);
        System.out.println();
    }

}
