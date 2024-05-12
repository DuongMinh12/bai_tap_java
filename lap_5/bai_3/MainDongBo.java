package bai_3;

import java.util.ArrayList;

public class MainDongBo {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();

        WriteNum writeNum = new WriteNum(1000, 10000, primes);
        ReadNum readNum = new ReadNum(primes);

        writeNum.start();
        readNum.start();
    }
}
