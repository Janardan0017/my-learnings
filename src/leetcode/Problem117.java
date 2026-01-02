package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem117 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root = connect(root);
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = null;
            for (int i = q.size(); i > 0; i--) {
                Node node = q.poll();
                node.next = temp;
                temp = node;
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return root;
    }

    static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

