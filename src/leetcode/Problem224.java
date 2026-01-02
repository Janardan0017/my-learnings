package leetcode;

import java.util.Stack;

public class Problem224 {

    public static void main(String[] args) {
        
    }

    public static int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != ' ' && c != ')') {
                stack.push(c);
            } else {
                char top = stack.pop();
                
            }
        }
        return 0;
    }
}