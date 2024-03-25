import java.util.Scanner;
//Bai 3: Nhập n số nguyên. Hãy sắp xếp giá trị của các số nguyên này theo thứ tự tăng dần.

public class Bai3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhap so luong phan tu trong mang:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu trong mang:");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        // System.err.println("arr.lenght: " + arr.length);
        Bai3.SapXepTang(arr);
        System.out.println("Ket Qua mang tang dan: ");
        Bai3.KetQua(arr);
    }

    public static void SapXepTang(int[] arr) {
        int dem = arr[0];
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    dem = arr[x];
                    arr[x] = arr[y];
                    arr[y] = dem;
                }
            }
        }
    }

    public static void KetQua(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
