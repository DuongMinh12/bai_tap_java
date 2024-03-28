import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // nhap chuoi
        System.out.print("Nhap chuoi A: ");
        String A = scanner.nextLine();
        System.out.print("Nhap chuoi B: ");
        String B = scanner.nextLine();

        int count = demSoLanXuarHien(A, B);
        System.out.println("So lan xuat hien chuoi B trong chuoi A: " + count);

        String C = loaiBoKhoanTrang(A);
        System.out.println("Chuoi C sau khi loai bo khoan trang: " + C);

        boolean symmetric = kiemTranDoiXung(A);
        System.out.println("Chuoi co doi xung hay khong: " + symmetric);

        String D = daoChuoi(A);
        System.out.println("Chuoi sau khi dao nguoc: " + D);
    }

    private static int demSoLanXuarHien(String A, String B) {
        int count = 0;
        int index = A.indexOf(B);
        while (index != -1) {
            count++;
            index = A.indexOf(B, index + 1);
        }
        return count;
    }

    private static String loaiBoKhoanTrang(String A) {
        return A.replaceAll("\\s", "");
    }

    private static boolean kiemTranDoiXung(String A) {
        return A.equals(new StringBuilder(A).reverse().toString());
    }

    private static String daoChuoi(String A) {
        StringTokenizer tokenizer = new StringTokenizer(A);
        StringBuilder reversed = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            reversed.insert(0, word);
            reversed.insert(0, " ");
        }
        return reversed.toString().trim();
    }
}
