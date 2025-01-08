package algorithm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MagicSquare {

    final static Random random = new Random();

    public static void main(String[] args) {

        long x = System.currentTimeMillis();
        // int[][] box = {{2,9,4},{7,5,3},{6,1,8}};
        int[][] box = getMagicSquare();
        long count = 0;
        while (!validateBox(box)) {
            // System.out.println(count);
            // printBox(box);
            box = getMagicSquare();
            count++;
        }
        printBox(box);
        long y = System.currentTimeMillis();
        System.out.println("Time taken: " + (y - x) + "ms and total checks is: " + count);
    }

    static int[][] getMagicSquare() {
        int[][] box = new int[3][3];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int digit = getRandomNumber(set);
                box[i][j] = digit;
                set.add(digit);
            }
        }
        return box;
    }

    static boolean validateBox(int[][] box) {
        // row check
        for (int i = 0; i < 3; i++) {
            int sum = box[i][0] + box[i][1] + box[i][2];
            if (sum != 15)
                return false;
        }
        // column check
        for (int i = 0; i < 3; i++) {
            int sum = box[0][i] + box[1][i] + box[2][i];
            if (sum != 15)
                return false;
        }
        // diagonal check
        int diagonal1 = box[0][0] + box[1][1] + box[2][2];
        if (diagonal1 != 15)
            return false;
        int diagonal2 = box[0][2] + box[1][1] + box[2][0];
        return diagonal2 == 15;
    }

    static int getRandomNumber(Set<Integer> set) {
        int n = random.nextInt();
        if (n > 0 && !set.contains(n))
            return n;
        else
            return getRandomNumber(set);
    }

    static void printBox(int[][] box) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(box[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}