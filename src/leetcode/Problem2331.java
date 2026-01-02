package leetcode;

import customclassess.TreeNode;

public class Problem2331 {

    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree(Arrays.asList(2,1,3,null,null,0,1));
        // BinaryTree binaryTree = new BinaryTree(Arrays.asList(2,0,0));
        // System.out.println(evaluateTree(binaryTree.getRoot()));
    }

    public static boolean evaluateTree(TreeNode<Integer> root) {
        if (root.val == 0) {
            return false;
        } else if (root.val == 1) {
            return true;
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
