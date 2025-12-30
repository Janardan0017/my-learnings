package interviewbit;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Queue<Integer> lq = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> aq = new ArrayDeque<>();

        int[] nums = {4, 6, 1, 7, 2, 9};
        for (int n : nums) {
            lq.add(n);
            pq.add(n);
            aq.add(n);
            // System.out.println(lq);
            // System.out.println(pq);
            // System.out.println(aq);
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
