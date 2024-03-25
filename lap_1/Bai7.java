import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan so trong mang: ");
        int n = scanner.nextInt();

        Fraction[] fractions = new Fraction[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan so thu " + (i + 1) + ": ");
            System.out.print("Nhap tu so: ");
            int numerator = scanner.nextInt();
            System.out.print("Nhap tu so: ");
            int denominator = scanner.nextInt();
            fractions[i] = new Fraction(numerator, denominator);
        }

        Fraction minFraction = fractions[0];
        Fraction maxFraction = fractions[0];
        for (int i = 1; i < n; i++) {
            if (fractions[i].compareTo(minFraction) < 0) {
                minFraction = fractions[i];
            }
            if (fractions[i].compareTo(maxFraction) > 0) {
                maxFraction = fractions[i];
            }
        }

        System.out.println("Phan so nho nhat: " + minFraction);
        System.out.println("Phan so lon nhat: " + maxFraction);

        scanner.close();
    }
}

class Fraction implements Comparable<Fraction> {
    private int numerator; 
    private int denominator; 

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        double thisValue = (double) this.numerator / this.denominator;
        double otherValue = (double) other.numerator / other.denominator;
        return Double.compare(thisValue, otherValue);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
