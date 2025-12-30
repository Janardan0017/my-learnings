package companies.paytm;

//Shift all even nodes to one side and odd nodes to other side
public class LinkedListProblem1 {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 1; i < 11; i++) {
            myLinkedList.add(i);
        }
        System.out.println(myLinkedList);

        ListNode<Integer> lastNode = myLinkedList.getHead();
        int length = 0;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            length++;
        }
        ListNode<Integer> current = myLinkedList.getHead();
        ListNode<Integer> even = null;
        ListNode<Integer> odd = null;
        while (current != null) {
            ListNode<Integer> temp = current;
            current = current.next;
            if (temp.val % 2 == 0) {
                if (even == null) {
                    even = temp;
                } else {
                    even.next = temp;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = temp;
                } else {
                    odd.next = temp;
                    odd = odd.next;
                }
            }
        }
        System.out.println(odd);
        System.out.println(even);
    }
}
