import java.util.ArrayList;
import java.util.Scanner;

public class Main_bt_2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Rectangle rectangle = new Rectangle();
        // Circle circle = new Circle();
        ArrayList<Rectangle> listRectangles = new ArrayList<>();
        ArrayList<Circle> listCircles = new ArrayList<>();

        double dienTichLN = 0;
        // int SLHinhCN = 0;
        // int SLHinhTron = 0;
        ShapeClass shape = null;

        System.out.print("Nhap so luong hinh muon nhap: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Chon hinh ban muon nhap: ");
            System.out.println("1. Hinh chu nhat.");
            System.out.println("2.Hinh tron.");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Rectangle newRectangle = new Rectangle();
                    newRectangle.Nhap();
                    listRectangles.add(newRectangle);
                    if (newRectangle.tinhDienTich() > dienTichLN) {
                        dienTichLN = newRectangle.tinhDienTich();
                        shape = newRectangle;
                    }
                    // SLHinhCN++;
                    break;
                case 2:
                    Circle newCircle = new Circle();
                    newCircle.Nhap();
                    listCircles.add(newCircle);
                    if (newCircle.tinhDienTich() > dienTichLN) {
                        dienTichLN = newCircle.tinhDienTich();
                        shape = newCircle;
                    }
                    // SLHinhTron++;
                    break;
                default:
                    System.out.println("Khong co lua chon nay, vui long nhap lai");
                    i--;
                    break;
            }
        }

        System.out.println();
        System.out.print("So luong hinh chu nhat la: ");
        System.out.println(listRectangles.size());
        System.out.print("So luong hinh tron la: ");
        System.out.println(listCircles.size());

        System.out.println("Hinh co dien tich lon nhat la: ");
        System.out.println(shape.toStringFunction());

    }
}
