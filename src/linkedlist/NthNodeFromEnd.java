package linkedlist;

public class NthNodeFromEnd {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node temp = node;
        for (int i = 2; i < 7; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        Node result = getNthFromLast(node, 3);
        if (result != null) {
            System.out.print(result.val);
        } else {
            System.out.print("Node not found");
        }
    }

    public static Node getNthFromLast(Node head, int nth) {
        if (head == null || nth <= 0) {
            return null;
        }

        Node first = head;
        Node second = head;

        // Move the first pointer nth steps ahead
        for (int i = 0; i < nth; i++) {
            if (first == null) {
                return null; // nth is greater than the length of the list
            }
            first = first.next;
        }

        // Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer is now at the nth node from the end
        return second;
    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}