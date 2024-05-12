package bai_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadNum extends Thread {
    private final ArrayList<Integer> primeNumbers;
    private final Object lock;

    public ReadNum(ArrayList<Integer> primeNumbers, Object lock) {
        this.primeNumbers = primeNumbers;
        this.lock = lock;
    }

    public void readFile() {
        synchronized (lock) {
            try {
                for (int prime : primeNumbers) {
                    System.out.println("Prime number printed: " + prime);
                    lock.notify(); // Thông báo cho luồng tìm số nguyên tố
                    lock.wait(); // Chờ cho luồng tìm số nguyên tố hoàn thành
                }
                lock.notify(); // Thông báo cho luồng tìm số nguyên tố kết thúc
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        readFile();
    }
}
