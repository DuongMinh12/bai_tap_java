package bai_3;

import java.util.ArrayList;

public class MainDongBo {
    public static void main(String[] args) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        Object lock = new Object();

        WriteNum finderThread = new WriteNum(1000, 10000, lock, primeNumbers);
        ReadNum printerThread = new ReadNum(primeNumbers, lock);

        finderThread.start();
        printerThread.start();
    }
}
