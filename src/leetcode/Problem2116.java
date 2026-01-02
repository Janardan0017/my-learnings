package leetcode;

public class Problem2116 {

    public static void main(String[] args) {
        Problem2116 obj = new Problem2116();
        System.out.println(obj.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(",
         "100011110110011011010111100111011101111110000101001101001111"));
        System.err.println(obj.canBeValid("(())", "1111"));
    }

    public boolean canBeValid(String s, String locked) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += 1;
            if (locked.charAt(i) == '1') {
                if (count % 2 == 0) {
                    count = 0;
                } else {
                    return false;
                }
            }
        }
        return count % 2 == 0;
    }
}
