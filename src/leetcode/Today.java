package leetcode;

import java.util.PriorityQueue;
import java.util.Iterator;

public class Today {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(6);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        return 0;
    }

    public static void main(String[] args) {
        Today today = new Today();
        today.minimumDeviation(new int[]{1});
    }
}
