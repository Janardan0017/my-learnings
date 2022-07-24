package leetcode;

import java.util.List;

public class LinkedList {

    ListNode head;

    public LinkedList() { }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public LinkedList(List<Integer> values) {
        if(values.isEmpty()) {
            return;
        }
        head = new ListNode(values.get(0));
        ListNode current = head;
        for(int i=1; i<values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
    }

    public LinkedList(int[] values) {
        if(values.length == 0) {
            return;
        }
        head = new ListNode(values[0]);
        ListNode current = head;
        for(int i=1; i<values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode temp = head;
        if(temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        while(temp != null) {
            sb.append(", ").append(temp.val);
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
