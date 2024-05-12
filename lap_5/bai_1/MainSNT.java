public class MainSNT {
    public static void main(String[] args) {
        Prime soNTThread = new Prime(1000, 10000);
        SumPrime sumSoNT = new SumPrime(soNTThread.getListSoNT());
        soNTThread.start();
        try {
            soNTThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sumSoNT.start();
    }
}
