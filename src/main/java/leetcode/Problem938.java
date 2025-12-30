package leetcode;

import custom.classess.TreeNode;

public class Problem938 {

    public int sum;

    public int rangeSumBST(TreeNode<Integer> root, int L, int R) {
        if (root == null)
            return 0;
        if (root.val >= L && root.val <= R)
            sum += root.val;
        rangeSumBST(root.left, L, R);
        rangeSumBST(root.right, L, R);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(18);
        print(treeNode);
        Problem938 obj = new Problem938();
        int sum = obj.rangeSumBST(treeNode, 7, 15);
        System.out.println(sum);
    }

    public static void print(TreeNode root) {
        if (root == null)
            return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
}