package leetcode;

import java.util.Arrays;

public class Problem114 {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(Arrays.asList(1,2,3,4,5,6,7,8,9));
        flatten(binaryTree.getRoot());
    }

    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        
        flatten(root.right);
    }
}
