package madeeasy.tree;

import java.util.*;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree() {
    }

    public Tree(T val) {
        root = new TreeNode<T>(val);
    }

    public void preOrder(TreeNode<T> root) {
        if (root != null) {
            System.out.println(root.getVal());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public List<T> preOrderTraversal(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> temp = stack.pop();
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

    public void inOrder(TreeNode<T> root) {
        if (root != null) {
            preOrder(root.getLeft());
            System.out.println(root.getVal());
            preOrder(root.getRight());
        }
    }

    public List<T> inOrderTraversal(TreeNode<T> root) {
        List<T> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> temp = stack.pop();
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

    public TreeNode<T> getRoot() {
        return root;
    }
}