package madeeasy.linkedlist;

public class ListNode<T> {

    public int val;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + val +
                ", next=" + next +
                '}';
    }
}