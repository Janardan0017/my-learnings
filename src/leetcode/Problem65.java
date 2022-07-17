package leetcode;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem65 {

    public static void main(String[] args) {
//        String[] nums = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
//        String[] nums = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        String[] nums = {"."};
        for (String num : nums) {
            boolean isNum = isNumber(num);
            System.out.println(isNum + " " + num);
        }
    }

    public static boolean isNumberBestSolution(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                numberSeen = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else
                return false;
        }
        return numberSeen;
    }

    public static boolean isNumberRegex(String s) {
        return s.trim().matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }

    public static boolean isNumber(String s) {
        int decimals = countDecimalPoints(s);
        if (decimals > 1 || s.length() == decimals) {
            return false;
        }
        // split from decimal point
        List<String> digits = Arrays.stream(s.split("\\.")).filter(e -> !e.isEmpty()).collect(Collectors.toList());
        String leftRegex;
        String rightRegex = null;
        if (digits.size() == 1) {
            if (s.charAt(0) == '.') {
                leftRegex = "\\d+((e|E)(\\+|-)?\\d+)?";
            } else if (s.charAt(s.length() - 1) == '.') {
                leftRegex = "(\\+|-)?\\d+";
            } else {
                leftRegex = "(\\+|-)?\\d+((e|E)(\\+|-)?\\d+)?";
            }
        } else {
            leftRegex = "(\\+|-)?\\d*";
            rightRegex = "\\d*((e|E)(\\+|-)?\\d+)?";
        }
        Pattern leftPattern = Pattern.compile(leftRegex);
        Matcher leftMatcher = leftPattern.matcher(digits.get(0));
        if (rightRegex != null) {
            Pattern rightPattern = Pattern.compile(rightRegex);
            Matcher rightMatcher = rightPattern.matcher(digits.get(1));
            return leftMatcher.matches() && rightMatcher.matches();
        }
        return leftMatcher.matches();
    }

    public static int countDecimalPoints(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '.') {
                count++;
            }
        }
        return count;
    }
}
