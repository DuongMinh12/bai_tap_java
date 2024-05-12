package bai_2;

import java.util.List;

public class MainDocGhi {
    public static void main(String[] args) {
        String fileName = "Number.txt";
        ThreadWrite primeThread = new ThreadWrite(1000, 10000, fileName);
        ThreadRead readThread = new ThreadRead(fileName);

        primeThread.start();
        try {
            primeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readThread.start();
        try {
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Integer> primes = readThread.getPrimes();
        System.out.println("Danh sach so nguyen to:");
        for (Integer prime : primes) {
            System.out.println(prime);
        }
    }
}
