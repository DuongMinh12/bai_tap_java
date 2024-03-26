import java.util.Scanner;

public class Main_btth1_4 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Complex cp1 = new Complex();
        Complex cp2 = new Complex();

        // nhap
        cp1.Nhap();
        cp2.Nhap();

        // xuat
        cp1.Xuat();

        // cong
        Complex cp3 = cp1.cong(cp2);
        System.out.println("Ket qua phep tinh tren la: ");
        cp3.Xuat();
    }
}
