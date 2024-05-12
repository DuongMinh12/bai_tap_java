import java.util.ArrayList;

public class SoNT extends Thread {
    private int min;
    private int max;
    private ArrayList<Integer> listSoNT = new ArrayList<>();

    public SoNT(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public ArrayList<Integer> getListSoNT() {
        return this.listSoNT;
    }

    @Override
    public void run() {
        for (int i = min; i <= max; i++) {
            if (KTSoNT(i)) {
                listSoNT.add(i);
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