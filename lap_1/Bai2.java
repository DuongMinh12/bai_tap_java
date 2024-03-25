import java.util.Scanner;

//Bai 2: Viết chương trình giải phương trình bậc hai ax2 + bx + c = 0.

 public class Bai2 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
        System.out.println("Nhap gia tri cua a: ");
        float a = Bai2.scanner.nextFloat();
        System.out.println("Nhap gia tri cua b: ");
        float b = Bai2.scanner.nextFloat();
        System.out.println("Nhap gia tri cua c: ");
        float c = Bai2.scanner.nextFloat();
        Bai2.PhuongTrinhBac2(a, b, c);
    }

    public static void PhuongTrinhBac2(float a, float b, float c){ 
        if(a==0){
           if (b==0) {
            System.out.println("Phuong trinh vo nghiem.");
           } else{
            System.out.println("Phuong trinh co mot nghiem: X = " + (-c/b));
           }
           return;
        } else{
            float delta = b*b - 4*a*c;
            if(delta>0){
                System.out.println("Phuong trinh co 2 nghiem:" + ((-b + Math.sqrt(delta))/(2*a)) + " và " +  ((-b - Math.sqrt(delta))/(2*a)));
            } else if (delta == 0) {
                System.out.println("Phuong trinh co nghiem kep: X = " + (-b/(2*a)));
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        }
    }   

 }
