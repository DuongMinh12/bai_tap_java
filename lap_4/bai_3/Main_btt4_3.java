import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main_btt4_3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // a) kiem tra nam nhuan va ngay dau tien cua nam
        int year = Calendar.getInstance().get(Calendar.YEAR);
        kiemTraNamNhuan(year);
        ngayDauTienCuaNam(year);

        // b) in ra theo nhieu dinh dang
        inRaNgayTheoCacDinhDang();

        // c) kiem tra ngay thu may trong tuan
        System.out.print("Nhap ngay theo dinh dang (dd/MM/yyy): ");
        String inputDate = scanner.next();
        ngayThuMayTrongTuan(inputDate);

        // d) ngay dau tien va cuoi cung cua thang
        System.out.print("Nhap ngay theo dinh dang (dd/MM/yyy): ");
        String inputMonth = scanner.next();
        ngayDauTienVaCuoiCungCuaThang(inputMonth);
    }

    // function

    public static void kiemTraNamNhuan(int year) {
        boolean namNhuan = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Nam " + year + " " + (namNhuan ? "la nam nhuan." : "khong phai nam nhuan."));
    }

    public static void ngayDauTienCuaNam(int year) {
        Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, 1);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println("Ngay dau tien cua nam " + year + " la thu " + dayOfWeek);
    }

    public static void inRaNgayTheoCacDinhDang() {
        Date currentDate = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("Ngay hien tai theo dinh dang dd/MM/yyyy: " + sdf1.format(currentDate));
        System.out.println("Ngay hien tai theo dinh dang yyyy-MM-dd: " + sdf2.format(currentDate));
        System.out.println("Ngay hien tai theo dinh dang dd MMMM yyyy: " + sdf3.format(currentDate));
    }

    public static void ngayThuMayTrongTuan(String dateTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            Date date = sdf.parse(dateTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println(dateTime + " la thu " + dayOfWeek);
        } catch (Exception e) {
            System.out.println("Dinh dang ngay khong hop le.");
        }
    }

    public static void ngayDauTienVaCuoiCungCuaThang(String month) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            Date date = sdf.parse(month);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date firstDayOfMonth = cal.getTime();

            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.DATE, -1);
            Date lastDayOfMonth = cal.getTime();

            System.out.println("Ngay dau tien cua thang: " + sdf.format(firstDayOfMonth));
            System.out.println("Ngay cuoi cung cua thang: " + sdf.format(lastDayOfMonth));
        } catch (Exception e) {
            System.out.println("Dinh dang khong hop le.");
        }
    }
}
