package leetcode.dailychallenges.jan2021;

import madeeasy.linkedlist.LinkedList;
import madeeasy.linkedlist.ListNode;

/**
 * Created for interview-preparation on 25/01/21
 */
public class MergeKSortedLists {

    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        if (head1.val > head2.val) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        ListNode previous = head1;
        ListNode current = head1.next;
        while (current != null && head2 != null) {
            if (head2.val < current.val) {
                ListNode temp = head2;
                head2 = head2.next;
                previous.next = temp;
                temp.next = current;
                previous = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if(head2 != null)
            previous.next = head2;
        return head1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        for (int i = 2; i < 13; i++) {
            list1.add(i);
        }

        LinkedList list2 = new LinkedList();
        for (int i = 13; i < 20; i++) {
            list2.add(i);
        }
        ListNode result = mergeTwoList(list2.getHead(), list1.getHead());
        System.out.println(getValues(result));
    }

    public static String getValues(ListNode head) {
        if (head == null)
            System.out.println("[]");
        StringBuilder stringBuilder = new StringBuilder("[");
        while (head.next != null) {
            stringBuilder.append(head.val).append(", ");
            head = head.next;
        }
        stringBuilder.append(head.val).append("]");
        return stringBuilder.toString();
    }
}
