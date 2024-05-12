package bai_3;

import java.util.ArrayList;

public class WriteNum extends Thread {
    private final int min;
    private final int max;
    private final Object lock;
    private final ArrayList<Integer> primeNumbers;
    // private boolean continute = true;

    public WriteNum(int min, int max, Object lock, ArrayList<Integer> primeNumbers) {
        this.min = min;
        this.max = max;
        this.lock = lock;
        this.primeNumbers = primeNumbers;

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

    public void wrileFile() {
        synchronized (lock) {
            for (int i = min; i <= max; i++) {
                if (KTSoNT(i)) {
                    primeNumbers.add(i);
                    System.out.println("Prime number found: " + i);
                    lock.notify(); // Thông báo cho luồng xuất số nguyên tố
                    try {
                        lock.wait(); // Chờ cho luồng xuất số nguyên tố hoàn thành
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notify(); // Thông báo cho luồng xuất số nguyên tố kết thúc
        }
    }

    @Override
    public void run() {
        wrileFile();
    }
}
