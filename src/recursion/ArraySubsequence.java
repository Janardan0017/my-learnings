package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySubsequence {

    static List<Integer> A = Arrays.asList(3, 1, 2);

    public static void main(String[] args) {
        getSubsequence(0, new ArrayList<>());
    }

    static void getSubsequence(int index, List<Integer> list) {
        if(index == A.size()) {
            System.out.println(list);
            return;
        }
        list.add(A.get(index));
        getSubsequence(index+1, list);
        list.remove(A.get(index));
        getSubsequence(index+1, list);
    }
}
