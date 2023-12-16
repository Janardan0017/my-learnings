import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Created by emp350 on 3/04/20
 */
public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=10; j++) {
                System.out.print(i*j+", ");
            }
            System.out.println();
        }
    }

}