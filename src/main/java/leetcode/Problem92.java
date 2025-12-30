package leetcode;

import linkedlist.ListNode;

public class Problem92 {

    public static void main(String[] args) {
        // LinkedList linkedList = new LinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        // System.out.println(linkedList);
        // ListNode head = reverseBetween(linkedList.head, 1, 3);
        // System.out.println(new LinkedList(head));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // this node is required to handle the case when we want to reverse from head
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prevNode = newHead;
        ListNode currentNode = head;
        // move currentNode to left position
        while (--left > 0) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            right--;
        }
        // swap nodes until reached the right location
        while (right-- > 1) {
            ListNode temp = currentNode.next;
            currentNode.next = temp.next;
            temp.next = prevNode.next;
            prevNode.next = temp;
        }
        if (newHead.next == head) { // if head is not moved
            newHead.next = null;
        } else { // if head is moved, reset head
            head = newHead.next;
            newHead.next = null;
        }
        return head;
    }
}
