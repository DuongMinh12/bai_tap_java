public class MainSNT {
    public static void main(String[] args) {
        SoNT soNTThread = new SoNT(1000, 10000);
        SumSoNT sumSoNT = new SumSoNT(soNTThread.getListSoNT());
        soNTThread.start();
        try {
            soNTThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sumSoNT.start();
    }
}
