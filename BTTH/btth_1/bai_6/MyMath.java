
public class MyMath {
    public static int UCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public static double GTmax(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    public static double GTmin(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }

    public static boolean SoNT(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int TinhTong(int n) {
        return (n * (n + 1)) / 2;
    }

    public static int TinhTriTD(int n) {
        return Math.abs(n);
    }

    public static double LamTron(double x) {
        return Math.round(x);
    }
}
