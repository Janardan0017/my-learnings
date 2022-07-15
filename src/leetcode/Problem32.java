package leetcode;

import java.util.Objects;
import java.util.Stack;

public class Problem32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses("()()()()"));
        System.out.println(longestValidParentheses("((()))"));
        System.out.println(longestValidParentheses("((("));
        System.out.println(longestValidParentheses(")))"));
    }

    public static int longestValidParentheses(String s) {
        int count = 0;
        int result = 0;
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // if stack is empty or char is '(' then push in stack
            if (stack.isEmpty() || c == '(') {
                stack.push(String.valueOf(c));
            } else { // now char is ')'
                // if top is '(' then pop and put 2 at top
                if (Objects.equals(stack.peek(), "(")) {
                    stack.pop();
                    stack.push("2");
                    mergeNums(stack);
                } else if (Objects.equals(stack.peek(), ")")) { // if top is also ')'
                    stack.push(")");
                } else {
                    int x = Integer.parseInt(stack.pop());
                    if (!stack.isEmpty() && Objects.equals(stack.peek(), "(")) {
                        stack.pop();
                        stack.push(String.valueOf(x + 2));
                    } else {
                        stack.push(String.valueOf(x));
                        stack.push(")");
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (Objects.equals(temp, ")") || Objects.equals(temp, "(")) {
                count = 0;
            } else {
                count += Integer.parseInt(temp);
            }
            result = Math.max(result, count);
        }
        return result;
    }

    static void mergeNums(Stack<String> stack) {
        int x = 0;
        try {
            x = Integer.parseInt(stack.pop());
            int y = Integer.parseInt(stack.pop());
            stack.push(String.valueOf(x+y));
        } catch (Exception ignored) {
            stack.push(String.valueOf(x));
        }
    }
}
