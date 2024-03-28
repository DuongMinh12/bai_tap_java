import java.util.Random;

public class Main_btt4_2 {
    private static Random random = new Random();

    public static void main(String[] args) {
        int n = random.nextInt(11) + 5;
        System.out.println("Danh sach " + n + " ao co mau va size ngau nhien:");
        for (int i = 0; i < n; i++) {
            ColorEnum randomColor = ColorEnum.values()[random.nextInt(ColorEnum.values().length)];
            SizeEnum randomSize = SizeEnum.values()[random.nextInt(SizeEnum.values().length)];
            Shirt shirt = new Shirt(randomColor, randomSize);
            shirt.Xuat();
        }
    }
}
