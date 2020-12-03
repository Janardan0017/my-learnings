package leetcode;

import java.util.Stack;

/**
 * Created for interview-preperation on 19/10/20
 */
public class Problem1021 {

    public static String removeOuterParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                builder.append(input, j + 1, i);
                j = i + 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

//        String input = "(()())(())";
        String input = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses("()()"));
    }
}
