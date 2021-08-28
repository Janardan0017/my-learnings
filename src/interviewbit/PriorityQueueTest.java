package interviewbit;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        while (Q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x == 1) {
                pq.add(y);
            } else if (x == 2) {
                int v = pq.size() > 0 ? pq.peek() : -1;
                System.out.println(v);
            } else {
                if (pq.size() > 0)
                    pq.poll();
            }
        }
    }
}
