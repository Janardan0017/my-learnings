package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
public class Problem15 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 6, 4, 5);
        Collections.sort(integers);
        System.out.println(integers);

        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new LinkedHashSet<>();
        set.add(Arrays.asList(1,2,3));
        set.add(Arrays.asList(1,2,3));
        System.out.println(set);
        list.addAll(set);
        System.out.println(list);
        List<Integer> collect = Stream.of(1, 3, 2).sorted().collect(Collectors.toList());
        System.out.println(collect);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}
