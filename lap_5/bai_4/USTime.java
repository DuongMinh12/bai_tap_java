package bai_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class USTime implements Runnable {
    @Override
    public void run() {
        while (true) {
            // Lấy múi giờ Mỹ
            LocalTime time = LocalTime.now().minusHours(7); // GMT-7
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(formatter);
            System.out.println("US Time: " + formattedTime);

            try {
                Thread.sleep(1000); // Dừng 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
