package madeeasy.tree;

import java.util.*;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree() {
    }

    public Tree(List<T> values) {
        if(values != null && !values.isEmpty()) {
            List<TreeNode<T>> levelNodes = new ArrayList<>();
            TreeNode<T> root = new TreeNode<>(values.get(0));
            levelNodes.add(root);
            int i = 1;
            while (!levelNodes.isEmpty()) {
                List<TreeNode<T>> newLevelNodes = new ArrayList<>();
                for(TreeNode<T> node: levelNodes) {
                    TreeNode<T> leftNode = null;
                    TreeNode<T> rightNode = null;
                    if(values.get(i) != null) {
                        leftNode = new TreeNode<>(values.get(i));
                        i++;
                    }
                    if(i < values.size() && values.get(i) != null) {
                        rightNode = new TreeNode<>(values.get(i));
                        i++;
                    }
                    node.setLeft(leftNode);
                    node.setRight(rightNode);
                    newLevelNodes.add(leftNode);
                    newLevelNodes.add(rightNode);
                }
                levelNodes = newLevelNodes;
            }
        }

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