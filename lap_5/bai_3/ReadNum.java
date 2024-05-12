package bai_3;

import java.util.ArrayList;

public class ReadNum extends Thread {
    private ArrayList<Integer> primes;

    public ReadNum(ArrayList<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (primes) {
                if (!primes.isEmpty()) {
                    System.out.println(primes.remove(0));
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
