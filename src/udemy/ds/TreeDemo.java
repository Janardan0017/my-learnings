package udemy.ds;

import leetcode.TreeNode;

public class TreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 13);
        insert(root, 17);
        insert(root, 9);
        insert(root, 14);
        insert(root, 20);
        insert(root, 8);
        insert(root, 11);
        insert(root, 18);
        delete(root, 12);

        System.out.println(root);
        System.out.println(getMinFromBst(root));
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null)
            return null;
        if (value < root.val) {
            root.left = delete(root.left, value);
        } else if (value > root.val) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int rightMin = getMinFromBst(root.right);
                root.val = rightMin;
                root.right = delete(root.right, rightMin);
            }
        }
        return root;
    }

    public static int getMinFromBst(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
