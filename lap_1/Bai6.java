import java.util.Scanner;

public class Bai6 {

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap nam: ");
        int year = scanner.nextInt();

        for (int month = 1; month <= 12; month++) {
            System.out.println("Thang " + month + " nam " + year);
            System.out.println("T2  T3  T4  T5  T6  T7  CN");

            int daysInMonth = getDaysInMonth(month, year);
            int startingDay = getStartingDayOfMonth(month, year);

            for (int i = 0; i < startingDay; i++) {
                System.out.print("    ");
            }

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%-4d", day);

                if ((day + startingDay) % 7 == 0) {
                    System.out.println();
                }
            }

            System.out.println("\n");
        }

        scanner.close();
    }

    private static int getDaysInMonth(int month, int year) {
        int daysInMonth;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                daysInMonth = 31;
                break;
            case 4, 6, 9, 11:
                daysInMonth = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = -1;
        }
        return daysInMonth;
    }

    private static int getStartingDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int h = (1 + (26 * (month + 1)) / 10 + (year % 100) + ((year % 100) / 4) + ((year / 100) / 4) + 5 * (year / 100)) % 7;
        return (h + 5) % 7;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
