package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem100 {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(Arrays.asList(1, null,1));
        BinaryTree binaryTree2 = new BinaryTree(Arrays.asList(1, null, 1));
        boolean sameTree = isSameTree2(binaryTree.getRoot(), binaryTree2.getRoot());
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

    public static void preOrder(TreeNode root, List<Integer> values) {
        if (root == null) {
            values.add(null);
            return;
        }
        values.add(root.val);
        preOrder(root.left, values);
        preOrder(root.right, values);
    }
}
