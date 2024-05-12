package bai_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class VNTime implements Runnable {
    @Override
    public void run() {
        while (true) {
            LocalTime time = LocalTime.now().plusHours(7); // GMT+7
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = time.format(formatter);
            System.out.println("Vietnam Time: " + formattedTime);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}