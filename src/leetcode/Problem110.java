package leetcode;

import madeeasy.tree.BinaryTreeNode;

/**
 * Created for interview-preperation on 2/12/20
 */
public class Problem110 {

    public static void main(String[] args) {

        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node20 = new BinaryTreeNode(20);
        BinaryTreeNode node15 = new BinaryTreeNode(15);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        node7.right = node5;

        System.out.println(print(node3));
    }

    public static boolean print(BinaryTreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            print(root.left);
            print(root.right);
            return true;
        }
        return false;
    }

    public static int getHeight(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
