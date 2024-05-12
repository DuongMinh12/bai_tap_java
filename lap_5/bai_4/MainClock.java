package bai_4;

public class MainClock {
    public static void main(String[] args) {
        Thread ukThread = new Thread(new UKTime());
        Thread vnThread = new Thread(new VNTime());
        Thread usThread = new Thread(new USTime());

        ukThread.start();
        vnThread.start();
        usThread.start();
    }
}
