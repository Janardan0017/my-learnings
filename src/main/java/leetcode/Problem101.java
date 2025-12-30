package leetcode;

import custom.classess.TreeNode;

public class Problem101 {

    public static void main(String[] args) {
//        List<Integer> values = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
//        List<Integer> values = Arrays.asList(1, 2, 3);
        // List<Integer> values = Arrays.asList(1, 2, 2, null, 3, null, 3);
        // BinaryTree binaryTree = new BinaryTree(values);
        TreeNode<Integer> root = new TreeNode<>(1);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        // check if left is equal to right
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null) {
            return false;
        } else if (rightNode == null) {
            return false;
        } else if (leftNode.val == rightNode.val) {
            return (isSymmetric(leftNode.left) && isSymmetric(rightNode.right))
                    && (isSymmetric(leftNode.right) && isSymmetric(rightNode.left));
        } else {
            return false;
        }
    }
}
