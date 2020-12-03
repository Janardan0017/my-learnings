package leetcode;

import madeeasy.linkedlist.LinkedList;
import madeeasy.linkedlist.ListNode;

/**
 * Created for interview-preperation on 11/06/20
 */
//https://leetcode.com/problems/reverse-linked-list/
public class Problem206 {

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev = null;
        ListNode temp = head;
        ListNode next = head.next;
        while(next != null){
            temp.next = prev;
            head = temp;
            prev = head;
            temp = next;
            next = temp.next;
        }
        if(temp != head){
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for(int i=0; i<14; i++){
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.length());
    }
}
