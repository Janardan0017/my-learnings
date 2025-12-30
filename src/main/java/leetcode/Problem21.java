package leetcode;

import linkedlist.ListNode;

public class Problem21 {

    public static void main(String[] args) {
        // LinkedList l1 = new LinkedList(Arrays.asList(11, 13, 15, 17));
        // LinkedList l2 = new LinkedList(Arrays.asList(8, 9, 10));
        // l1.head = mergeTwoLists(l1.head, l2.head);
        // System.out.println(l1);
    }

    public static ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> newHead = new ListNode<>(-101);
        newHead.next = l1;
        l1 = newHead;
        while (l2 != null) {
            if(l1.next == null) {
                l1.next = l2;
                break;
            } else if (l2.val <= l1.next.val) {
                ListNode temp = l2;
                l2 = l2.next;
                temp.next = l1.next;
                l1.next = temp;
                l1 = temp;
            } else {
                l1 = l1.next;
            }
        }
        return newHead.next;
    }
}
