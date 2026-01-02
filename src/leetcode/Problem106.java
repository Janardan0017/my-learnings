package leetcode;

import java.util.HashMap;
import java.util.Map;

class Problem106 {

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9, 3, 15, 20, 7};
        Problem106 obj = new Problem106();
        TreeNode root = obj.buildTree(inorder, postorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    private TreeNode createTree(int[] inArr, int inStart, int inEnd, int[] postArr, int postStart, int postEnd,
            Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postArr[postEnd]);
        int rootIndex = inMap.get(postArr[postEnd]);
        int leftRemaining = rootIndex - inStart;
        int rightRemaining = inEnd - rootIndex;
        root.left = createTree(inArr, inStart, rootIndex - 1, postArr, postStart, postStart + leftRemaining - 1, inMap);
        root.right = createTree(inArr, rootIndex + 1, inEnd, postArr, postEnd - rightRemaining, postEnd - 1, inMap);
        return root;
    }

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
