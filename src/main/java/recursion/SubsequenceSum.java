package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsequenceSum {

    static int k = 6;
    static int count = 0;
    static List<Integer> arr = Arrays.asList(1, 2, 3, 4);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        subsequenceEqualToK(0, k, stack);
        System.out.println(stack);
    }

    static void subsequenceEqualToK(int index, int k, Stack<Integer> subsequence) {
        
    }
}
