package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        System.out.println(head);
        System.out.println(reverseKGroup(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // return iterativeSolution(head, k);
        return recursiveSolution(head, k);
    }

    public static ListNode iterativeSolution(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode end = head;
        int count = 1;
        while(end.next != null) {
            end = end.next;
            count++;
        }
        // if there are less element than group then no need to reverse
        if(count < k) {
            return head;
        }
        ListNode addPoint = end;
        // loop on each group
        for(int i=0; i<count/k; i++) {
            ListNode nextEnd = head;
            // loop on each group item
            for(int j=0; j<k; j++) {
                if(head == addPoint) {
                    break;
                }
                ListNode temp = head;
                head = head.next;
                temp.next = addPoint.next;
                addPoint.next = temp;
            }
            System.out.println(end);
            addPoint = nextEnd;
        }
        if(count % k != 0) {
            ListNode temp = head;
            head = end.next;
            end.next = null;
            addPoint.next = temp;
        }
        return head;
    }

    private static ListNode recursiveSolution(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode tail = head;
        for(int i=0; i<k; i++) {
            if(tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = recursiveSolution(tail, k);
        return newHead;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        while(head != tail) {
            ListNode temp = head;
            head = head.next;
            temp.next = tail.next;
            tail.next = temp;
        }
        return head;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode add(int nextVal) {
            this.next = new ListNode(nextVal);
            return this.next;
        }

        @Override
        public String toString() {
            ListNode temp = this;
            List<String> values = new ArrayList<>();
            while (temp != null) {
                values.add(String.valueOf(temp.val));
                temp = temp.next;
            }
            return String.join(" -> ", values);
        }
    }
}
