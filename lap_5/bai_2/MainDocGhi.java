package bai_2;

public class MainDocGhi {
    public static void main(String[] args) {
        String fileName = "Number.txt";
        Object lock = new Object();
        ThreadRead generator = new ThreadRead(1000, 10000, fileName, lock);
        // boolean continute = generator.getContinute();
        ThreadWrite reader = new ThreadWrite(fileName, lock);

        generator.start();
        reader.start();
    }
}
