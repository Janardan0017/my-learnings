package madeeasy.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created for interview-preperation on 15/08/20
 */
public class Problem1 {

    public static boolean isParenthesisBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char s : str.toCharArray()) {
            if (s == '(' || s == '{' || s == '[') {
                stack.push(s);
            } else if (s == ')' || s == '}' || s == ']') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!input.equalsIgnoreCase("Exit")) {
            System.out.println(isParenthesisBalanced(input));
            input = in.nextLine();
        }
    }
}
