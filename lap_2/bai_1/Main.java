public class Main {
    // ----------main-------
    public static void main(String[] args) {

        Point2D A = new Point2D();
        Point2D B = new Point2D();

        A.Nhap();
        B.Nhap();

        // -- tinh khoan cach
        System.out.println("Khoan cach giua A va B: " + A.distance(B));
        System.out.println();

        // tinh di chuyen diem
        A.movePoint();
        B.movePoint();
    }
}
