package madeeasy.linkedlist;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        System.out.println("Select option: 1-insertAtBegin\n2-insertAtEnd\n3-insert at position\n4-removeFromBegin\n5-removeFromEnd\n6-removeMatchingNode");
        String option = in.next();
        while (!option.equals("q")) {
            System.out.println("Enter a digit...");
            int n = in.nextInt();
            switch (option) {
                case "insertAtBegin": {
                    ll.insertAtBegin(n);
                    break;
                }
                case "insertAtEnd": {
                    ll.insertAtEnd(n);
                    break;
                }
                case "insert": {
                    System.out.println("Enter position..");
                    int pos = in.nextInt();
                    ll.insert(n, pos);
                    break;
                }
                case "removeFromBegin": {
                    ll.removeFromBegin();
                    break;
                }
                case "removeFromEnd": {
                    ll.removeFromEnd();
                    break;
                }
                case "removeMatchingNode": {
                    ll.removeMatchingNode(5);
                    break;
                }
                default: {
                    System.out.println("Invalid operation!");
                }
            }
            System.out.println(ll);
            System.out.println("Select option: 1-insertAtBegin\n2-insertAtEnd\n3-insert at position\n4-removeFromBegin\n5-removeFromEnd\n6-removeMatchingNode");
            option = in.next();
        }
        System.out.println(ll);
    }
}