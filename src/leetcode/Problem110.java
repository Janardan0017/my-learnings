package leetcode;

import madeeasy.tree.TreeNode;

/**
 * Created for interview-preparation on 2/12/20
 */
public class Problem110 {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        node3.setLeft(node9);
        node3.setRight(node20);
        node20.setLeft(node15);
        node20.setRight(node7);
        node7.setRight(node5);

        System.out.println(print(node3));
    }

    public static boolean print(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight())) <= 1) {
            print(root.getLeft().getLeft());
            print(root.getRight());
            return true;
        }
        return false;
    }

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }
}
