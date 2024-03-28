import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main_btt4_4 {
    public static void main(String[] args) {
        // String dir = System.getProperty("user.dir");
        String fileName = "lap_4\\bai_4\\text.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            int N = Integer.parseInt(reader.readLine());
            int[] numbers = new int[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }

            reader.close();

            Arrays.sort(numbers);

            System.out.println("Day so sap xep tang dan:");
            for (int num : numbers) {
                System.out.println(num);
            }

        } catch (IOException e) {
            System.err.println("Khong the doc tep: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Du lieu khong hop le: " + e.getMessage());
        }
    }
}
