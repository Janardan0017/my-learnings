package madeeasy.tree;

import java.util.*;

public class Tree {

    private TreeNode root;

    public Tree() {
    }

    public Tree(int val) {
        root = new TreeNode(val);
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getVal());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.getVal());
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.getLeft());
            System.out.println(root.getVal());
            preOrder(root.getRight());
        }
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.getVal());
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
        return res;
    }

    public TreeNode getRoot() {
        return root;
    }
}