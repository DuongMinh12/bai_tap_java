// import java.util.Scanner;

public class Main_btth1_6 {
    // private static Scanner scanner = new Scanner(System.in);
    // private static MyMath myMath = new MyMath();

    public static void main(String[] args) {
        System.out.println("Uoc chung lon nhat la: " + MyMath.UCLN(12, 18));
        System.out.println("Gia tri lon nhat la: " + MyMath.GTmax(3, 7.5, 4.2));
        System.out.println("Gia tri nho nhat la: " + MyMath.GTmin(3, 7.5, 4.2));
        System.out.println("Day co phai la so nguyen to khong? " + MyMath.SoNT(5));
        System.out.println("Tong cua day so la: " + MyMath.TinhTong(10));
        System.out.println("Tri tuyet doi la: " + MyMath.TinhTriTD(-7));
        System.out.println("So sau khi lam tron: " + MyMath.LamTron(5.6));
    }
}
