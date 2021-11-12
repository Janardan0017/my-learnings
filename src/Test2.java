import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        while (x != -1) {
            System.out.println(get3XPlusOne(x));
            x = in.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
    }

    static String get3XPlusOne(int x) {
        StringBuilder sb = new StringBuilder();
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            sb.append(x).append(" ");
        }
        return sb.toString();
    }
}
