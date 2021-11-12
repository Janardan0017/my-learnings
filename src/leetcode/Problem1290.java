package leetcode;


import madeeasy.linkedlist.ListNode;
import madeeasy.linkedlist.MyLinkedList;

/**
 * Created for interview-preperation on 11/06/20
 */
//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class Problem1290 {

    public static int getDecimalValue(ListNode<Integer> head) {
        int len = 0;
        ListNode<Integer> temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        int sum = 0;
        while (temp != null) {
            len--;
            if (temp.val == 1) {
                sum += Math.pow(2, len);
            }
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i % 2);
        }
        System.out.println(list);
        System.out.println(list.length());
        System.out.println(getDecimalValue(list.getHead()));
    }
}
