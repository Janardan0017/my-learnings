package madeeasy.linkedlist;

public class Problem69 {

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        for (int i = 1; i < 10; i++) {
            list1.insertAtEnd((int) (Math.random() * i));
        }
        LinkedList list2 = new LinkedList();
        for (int i = 1; i < 10; i++) {
            list2.insertAtEnd((int) (Math.random() * i));
        }
        getCommonElement(list1.getHead(), list2.getHead());
    }

    public static void getCommonElement(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {
            int x = head1.val;
            int y = head2.val;
            if (x == y) {
                System.out.println(x);
                head1 = head1.next;
                head2 = head2.next;
            } else if (x < y) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
    }
}