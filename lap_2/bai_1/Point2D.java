
import java.util.Scanner;

public class Point2D {
    private static Scanner scanner = new Scanner(System.in);
    // --------function-----------

    private int x;
    private int y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int pointX, int pointy) {
        this.x = pointX;
        this.y = pointy;
    }

    public void movePoint() {
        System.out.print("Nhap vao khoan cach hoanh do muon di chuyen: ");
        int dx = scanner.nextInt();

        System.out.print("Nhap vao khoan cach tung do muon di chuyen: ");
        int dy = scanner.nextInt();

        this.x += dx;
        this.y += dy;
        show();
    }

    public double distance(Point2D d2) {
        return Math.sqrt((this.x - d2.x) * (this.x - d2.x) + (this.y - d2.y) * (this.y - d2.y));

    }

    public void show() {
        System.out.println("Toa do diem: (" + this.x + " ; " + this.y + ")");
        System.out.println();
    }

    public void setX(int setx) {
        this.x = setx;
    }

    public void setY(int sety) {
        this.y = sety;
    }

    public void Nhap() {
        System.out.print("Nhap vao hoanh do: ");
        setX(scanner.nextInt());
        System.out.print("Nhap vao tung do: ");
        setY(scanner.nextInt());
        show();
    }
}
