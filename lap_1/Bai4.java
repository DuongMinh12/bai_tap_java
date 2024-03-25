import java.util.Scanner;

public class Bai4 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhap vao so thang: ");
        int thang = scanner.nextInt();
        System.out.println("Nhap vao so nam: ");
        int nam = scanner.nextInt();
        Bai4.SoNgayCuaThang(thang, nam);
    }

    public static void SoNgayCuaThang(int month, int year) {
        if (year > 0 && month > 0 && month < 13) {
            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    System.out.println("Thang " + month + " co 31 ngay.");
                    break;
                case 4, 6, 9, 11:
                    System.out.println("Thang " + month + " co 30 ngay.");
                    break;
                default:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        System.out.println("Thang 2 co 29 ngay.");
                    } else {
                        System.out.println("Thang 2 co 28 ngay.");
                    }
                    break;
            }
        } else{
            System.out.println("Thang hoac nam ban nhap vao khong hop le.");
        }
    }

}
