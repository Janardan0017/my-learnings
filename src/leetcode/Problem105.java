package leetcode;

import java.util.HashMap;
import java.util.Map;

class Problem105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Problem105 obj = new Problem105();
        TreeNode root = obj.buildTree(preorder, inorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> preMap = new HashMap<>();
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            inMap.put(inorder[i], i);
            preMap.put(preorder[i], i);
        }
        int i = 0;
        int rootIndex = inMap.get(preorder[0]);
        int j = preorder.length - 1;
        createLeftSubtree(root, preorder, inorder, i, rootIndex - 1, preMap, inMap);
        createRightSubtree(root, preorder, inorder, rootIndex + 1, j, preMap, inMap);
        return root;
    }

    private void createLeftSubtree(TreeNode root, int[] preorder, int[] inorder, int i, int j,
            Map<Integer, Integer> preMap, Map<Integer, Integer> inMap) {
        if (i > j) {
            return;
        }
        if (i == j) {
            root.left = new TreeNode(inorder[i]);
            return;
        }
        int rootIndex = getRootIndex(inorder, i, j, preMap, inMap);
        root.left = new TreeNode(inorder[rootIndex]);
        createLeftSubtree(root.left, preorder, inorder, i, rootIndex - 1, preMap, inMap);
        createRightSubtree(root.left, preorder, inorder, rootIndex + 1, j, preMap, inMap);
    }

    private void createRightSubtree(TreeNode root, int[] preorder, int[] inorder, int i, int j,
            Map<Integer, Integer> preMap, Map<Integer, Integer> inMap) {
        if (i > j) {
            return;
        }
        if (i == j) {
            root.right = new TreeNode(inorder[i]);
            return;
        }
        int rootIndex = getRootIndex(inorder, i, j, preMap, inMap);
        root.right = new TreeNode(inorder[rootIndex]);
        createLeftSubtree(root.right, preorder, inorder, i, rootIndex - 1, preMap, inMap);
        createRightSubtree(root.right, preorder, inorder, rootIndex + 1, j, preMap, inMap);
    }

    private int getRootIndex(int[] inorder, int i, int j, Map<Integer, Integer> preMap, Map<Integer, Integer> inMap) {
        int mapIndex = preMap.size();
        int index = j;
        for (int k = i; k <= j; k++) {
            int currentIndex = preMap.get(inorder[k]);
            if (currentIndex < mapIndex) {
                index = k;
                mapIndex = currentIndex;
            }
        }
        return index;
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
