package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumbers {

    public static void main(String[] args) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int x = 0;
        while (count < 3) {
            System.out.println("Checking for: "+x);
            if(isArmstrongNumber(x)) {
                list.add(x);
                count++;
            }
            x++;
        }
        System.out.println(list);
    }

    public static boolean isArmstrongNumber(int n) {
        int x = n;
        int sum = 0;
        while (x > 0) {
            int t = x % 10;
            sum += (t * t * t);
            x /= 10;
        }
        return sum == n;
    }
}
