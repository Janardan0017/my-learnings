package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        Arrays.sort(arr);
        uniqueSum(0, arr, 4, new LinkedList<>());
    }

    static void uniqueSum(int index, int[] arr, int target, List<Integer> temp) {
        if(target == 0) {
            System.out.println(temp);
            return;
        }
        for(int i=index; i<arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) return;
            temp.add(arr[i]);
            uniqueSum(i+1, arr, target-arr[i], temp);
            temp.remove(temp.size()-1);
        }
    }
}
