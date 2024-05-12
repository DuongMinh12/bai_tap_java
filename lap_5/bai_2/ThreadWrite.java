package bai_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ThreadWrite extends Thread {
    private final String filename;
    private final Object lock;

    public ThreadWrite(String filename, Object lock) {
        this.filename = filename;
        this.lock = lock;
    }

    // public ArrayList<Integer> DocFile() {
    // ArrayList<Integer> listSoNT = new ArrayList<Integer>();
    // try {
    // BufferedReader reader = new BufferedReader(new FileReader(filename));

    // String line;
    // while ((line = reader.readLine()) != null) {
    // listSoNT.add(Integer.parseInt(line));
    // }
    // reader.close();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return listSoNT;
    // }

    @Override
    public void run() {
        synchronized (lock) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                ArrayList<Integer> primes = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    primes.add(Integer.parseInt(line));
                }
                System.out.println("Prime numbers read from file:");
                for (int prime : primes) {
                    System.out.println(prime);
                }
                lock.wait(); // Chờ cho luồng ghi kết thúc
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
