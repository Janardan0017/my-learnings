package leetcode;

import custom.classess.TreeNode;

public class Problem617 {

    public static void main(String[] args) {
        // BinaryTree binaryTree1 = new BinaryTree(Arrays.asList(1, 3, 2, 5));
        // BinaryTree binaryTree2 = new BinaryTree(Arrays.asList(2, 1, 3, null, 4, null, 7));
        Problem617 problem617 = new Problem617();
        // TreeNode treeNode = problem617.mergeTrees(binaryTree1.getRoot(), binaryTree2.getRoot());
        // System.out.println(treeNode);
    }
    TreeNode root;
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        root = merge(root1, root2);
        root.left = merge(root1.left, root2.left);
        root.right = merge(root1.right, root2.right);
        return root;
    }

    public TreeNode merge(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return new TreeNode(root1.val);
        } else if (root1 == null) {
            return new TreeNode(root2.val);
        } else {
            return new TreeNode(root1.val + root2.val);
        }


//        if(root1 == null && root2 == null) {
//            root = null;
//        } else if(root1 != null && root2 == null) {
//            root = new TreeNode(root1.val);
//            merge(root1.left, null, root.left);
//            merge(root1.right, null, root.right);
//        } else if(root1 == null) {
//            root = new TreeNode(root2.val);
//            merge(null, root2.left, root.left);
//            merge(null, root2.right, root.right);
//        } else {
//            root = new TreeNode(root1.val + root2.val);
//            merge(root1.left, root2.left, root.left);
//            merge(root1.right, root2.right, root.right);
//        }
    }
}
