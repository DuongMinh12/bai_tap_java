package bai_3;

import java.util.ArrayList;

public class WriteNum extends Thread {
    private final int min;
    private final int max;

    private ArrayList<Integer> primes;

    public WriteNum(int min, int max, ArrayList<Integer> primes) {
        this.min = min;
        this.max = max;
        this.primes = primes;
    }

    @Override
    public void run() {
        for (int num = min; num <= max; num++) {
            if (isPrime(num)) {
                synchronized (primes) {
                    primes.add(num);
                }
            }
        }
    }

    private boolean isPrime(int num) {
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
