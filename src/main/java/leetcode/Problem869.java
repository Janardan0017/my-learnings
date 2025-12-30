package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem869 {

    public static void main(String[] args) {

    }

    public boolean reorderdPowerOf2(int n) {
        // if n = 1, return true
        // power of 2 ends with 2, 4, 6, 8
        Map<Integer, Integer> digitCountMap = new HashMap<>();
        int temp = n;
        while (temp > 0) {
            int lastDigit = temp % 10;
            if(digitCountMap.containsKey(lastDigit)) {
                digitCountMap.put(lastDigit, digitCountMap.get(lastDigit) + 1);
            } else {
                digitCountMap.put(lastDigit, 1);
            }
            temp /= 10;
        }

        int lengthOfn = digitCount(n);
        int i=0;

        return true;
    }

    public int digitCount(int n) {
        if(n == 0) {
            return 0;
        }
        return 1 + digitCount(n / 10);
    }

    public boolean isEqualLengthDigit(int x, int y) {
        while (x > 0 && y > 0) {
            x /= 10;
            y /= 10;
        }
        return x == y;
    }
}
