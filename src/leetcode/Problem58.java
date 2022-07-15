package leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

public class Problem58 {

    public static void main(String[] args) {
        String s = " as    df  gh  ";
        System.out.println(lengthOfLastWord("sdafd sdf sd as"));
        System.out.println(lengthOfLastWord("sdafd sdf sd   asdfgh"));
        System.out.println(lengthOfLastWord("  sdafd sdf sd ads    "));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length()-1;
        while (i>=0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length()-i-1;
    }
}
