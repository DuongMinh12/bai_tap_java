package bai_2;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ThreadRead extends Thread {
    private final int min;
    private final int max;
    private final String filename;
    private final Object lock;
    // private boolean continute = true;

    public ThreadRead(int min, int max, String filename, Object lock) {
        this.min = min;
        this.max = max;
        this.filename = filename;
        this.lock = lock;

    }

    // public boolean getContinute() {
    // return this.continute;
    // }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                for (int i = min; i <= max; i++) {
                    if (KTSoNT(i)) {
                        writer.write(i + "\n");
                        writer.flush();
                    }
                }
                lock.notify();
                // continute = false;
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean KTSoNT(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
