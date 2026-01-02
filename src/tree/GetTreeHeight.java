package tree;

import java.util.List;

import customclassess.TreeNode;

public class GetTreeHeight {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.create(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(getHeight(root));
        System.out.println(root);
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0; 
        }else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
