package bai_2;

public class Main {

    public static void main(String[] args) {
        Time A = new Time();
        A.Nhap();
        Time B = new Time(2, 25, 60);

        A.soSanh(B);

        while (true) {
            try {
                Thread.sleep(1000);
                A.tang1Giay();
            } catch (Exception e) {
            }
        }
    }

}