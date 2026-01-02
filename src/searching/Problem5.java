package searching;

import java.util.HashMap;
import java.util.Map;

public class Problem5 {

    public static void main(String[] args) {
        int[] ar = {1, 2, 2, 3, 4};
        System.out.println(getMaxOccurringElement(ar));
    }

    private static int getMaxOccurringElement(int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int maxOccurrence = 0;
        for (int i : ar) {
            Integer value = map.get(i);
            if (value == null) {
                value = 1;
                map.put(i, value);
            } else {
                value += 1;
                map.put(i, value);
            }
            if (value > maxOccurrence) {
                maxOccurrence = value;
                k = i;
            }
        }
        return k;
    }
}
