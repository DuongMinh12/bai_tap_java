package bai_2;

public class MainDocGhi {
    public static void main(String[] args) {
        String fileName = "Number.txt";
        Object lock = new Object();
        ThreadWrite generator = new ThreadWrite(1000, 10000, fileName, lock);
        // boolean continute = generator.getContinute();
        ThreadRead reader = new ThreadRead(fileName, lock);

        generator.start();
        reader.start();
    }
}
