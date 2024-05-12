package bai_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class UKTime implements Runnable {
    @Override
    public void run() {
        while (true) {
            // Lấy múi giờ Anh
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(formatter);
            System.out.println("UK Time: " + formattedTime);

            try {
                Thread.sleep(1000); // Dừng 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}