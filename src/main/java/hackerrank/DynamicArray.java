package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DynamicArray {

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));
        List<Integer> integers = dynamicArray(2, queries);
        System.out.println(integers);

    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> answers = new ArrayList<>();
        List<Integer>[] ar = new ArrayList[n];
        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            int idx = (query.get(1) ^ lastAnswer) % n;
            if (query.get(0) == 1) {
                List<Integer> idxList = ar[idx];
                if (Objects.isNull(idxList)) {
                    idxList = new ArrayList<>();
                }
                idxList.add(query.get(2));
            } else {
                lastAnswer = ar[idx].get(query.get(2) % (Objects.isNull(query.get(idx)) ? 0 : queries.get(idx).size()));
                answers.add(lastAnswer);
            }
        }
        return answers;
    }
}
