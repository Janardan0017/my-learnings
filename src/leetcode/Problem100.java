package leetcode;

import java.util.ArrayList;
import java.util.List;

import customclassess.TreeNode;

public class Problem100 {

    public static void main(String[] args) {
        TreeNode<Integer> tree1 = new TreeNode<>(1);
        TreeNode<Integer> tree2 = new TreeNode<>(1);
        boolean sameTree = isSameTree2(tree1, tree2);
        System.out.println(sameTree);
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        } else {
            return false;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pValues = new ArrayList<>();
        List<Integer> qValues = new ArrayList<>();
        preOrder(p, pValues);
        preOrder(q, qValues);
        return pValues.equals(qValues);
    }

    public static void preOrder(TreeNode<Integer> root, List<Integer> values) {
        if (root == null) {
            values.add(null);
            return;
        }
        values.add(root.val);
        preOrder(root.left, values);
        preOrder(root.right, values);
    }
}
