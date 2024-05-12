import java.util.ArrayList;

public class SumSoNT extends Thread {
    private long sum = 0;
    private ArrayList<Integer> listSoNT;

    public SumSoNT(ArrayList<Integer> listSoNT) {
        this.listSoNT = listSoNT;
    }

    public long getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        for (int so : listSoNT) {
            sum += so;
        }
        System.out.println("Tong cac so nguyen to la: " + sum);
    }
}