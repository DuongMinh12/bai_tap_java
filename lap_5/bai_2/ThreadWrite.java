package bai_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadWrite extends Thread {
    private final int min;
    private final int max;
    private final String fileName;

    public ThreadWrite(int min, int max, String fileName) {
        this.min = min;
        this.max = max;
        this.fileName = fileName;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = min; i <= max; i++) {
                if (isPrime(i)) {
                    bufferedWriter.write(i + "\n");
                }
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
