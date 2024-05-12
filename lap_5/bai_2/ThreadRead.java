package bai_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadRead extends Thread {
    private List<Integer> primes = new ArrayList<>();
    private final String fileName;

    public ThreadRead(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Danh sách số nguyên tố trong file:");

            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                primes.add(Integer.parseInt(line));
                System.out.println(line);
            }
            reader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
