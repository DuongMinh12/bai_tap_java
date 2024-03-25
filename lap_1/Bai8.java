import java.util.Arrays;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        nhapMang(arr, scanner);
        int soChan = demSoChan(arr);
        int soLe = demSoLe(arr);
        double giaTriTrungBinh = tinhGiaTriTrungBinh(arr);
        int max = timPhanTuLonNhat(arr);
        int min = timPhanTuNhoNhat(arr);
        System.out.print("Mang sau khi xuat theo chieu nguoc lai: ");
        xuatMangNguoc(arr);
        Arrays.sort(arr);
        System.out.print("Mang sau khi sap xep tang dan: ");
        xuatMang(arr);
        System.out.println("So phan tu chan: " + soChan);
        System.out.println("So phan tu le: " + soLe);
        System.out.println("Gia tri trung binh cua mang: " + giaTriTrungBinh);
        System.out.println("Phan tu lon nhat cua mang: " + max);
        System.out.println("Phan tu nho nhat cua mang: " + min);
        scanner.close();
    }

    private static void nhapMang(int[] arr, Scanner scanner) {
        System.out.print("Nhap cac phan tu cua mang:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    private static void xuatMang(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void xuatMangNguoc(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int demSoChan(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int demSoLe(int[] arr) {
        return arr.length - demSoChan(arr);
    }

    private static double tinhGiaTriTrungBinh(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    private static int timPhanTuLonNhat(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int timPhanTuNhoNhat(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
