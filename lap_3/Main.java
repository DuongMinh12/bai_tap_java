public class Main {
    public static void main(String[] args) {
        MangPhanSo mangPhanSo = new MangPhanSo();
        PhanSo[] arr = mangPhanSo.nhapMangPS();
        // mangPhanSo.xuatMangPS(arr);

        mangPhanSo.mangTangGiam(arr);
        mangPhanSo.xuatPhanTu(arr);
    }
}
