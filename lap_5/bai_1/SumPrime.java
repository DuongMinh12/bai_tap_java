import java.util.ArrayList;

public class SumPrime extends Thread {
    private long sum = 0;
    private ArrayList<Integer> listPrimes;

    public SumPrime(ArrayList<Integer> listPrimes) {
        this.listPrimes = listPrimes;
    }

    public long getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        for (int so : listPrimes) {
            sum += so;
        }
        System.out.println("Tong cac so nguyen to la: " + sum);
    }
}