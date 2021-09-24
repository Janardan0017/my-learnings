package companies.accolite;


import madeeasy.linkedlist.MyLinkedList;
import madeeasy.linkedlist.ListNode;

public class PrintReverseOfLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        printReverse(list.getHead());
    }

    public static void printReverse(ListNode<Integer> head) {
        if(head == null)
            return;
        printReverse(head.next);
        System.out.println(head.val);
    }

}
