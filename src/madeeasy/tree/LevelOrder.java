package madeeasy.tree;

import java.util.LinkedList;
import java.util.Random;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = TreeUtil.getTestTree();
        levelOrder(node1);
        System.out.println(getHeight(node1));
    }

    public static void levelOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        LinkedList<TreeNode<Integer>> linkedList = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        linkedList.add(root);
        level.add(0);
        int prevLevel = 0;
        StringBuilder sb = new StringBuilder();
        while (linkedList.size() > 0) {
            TreeNode<Integer> currentNode = linkedList.poll();
            int currentLevel = level.poll();
            if (prevLevel != currentLevel) {
                prevLevel = currentLevel;
                sb.append("\n");
            } else {
                sb.append(" ");
            }
            sb.append(currentNode.getVal());
            if (currentNode.getLeft() != null) {
                linkedList.add(currentNode.getLeft());
                level.add(currentLevel + 1);
            }
            if (currentNode.getRight() != null) {
                linkedList.add(currentNode.getRight());
                level.add(currentLevel + 1);
            }
        }
        System.out.println(sb);
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode<Integer>> linkedList = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        linkedList.add(root);
        level.add(0);
        int currentLevel = 0;
        while (linkedList.size() > 0) {
            TreeNode<Integer> currentNode = linkedList.poll();
            currentLevel = level.poll();
            if (currentNode.getLeft() != null) {
                linkedList.add(currentNode.getLeft());
                level.add(currentLevel + 1);
            }
            if (currentNode.getRight() != null) {
                linkedList.add(currentNode.getRight());
                level.add(currentLevel + 1);
            }
        }
        return currentLevel;
    }

    public static TreeNode<Integer> insert(TreeNode<Integer> root, int data) {
        if (root == null) {
            return new TreeNode<Integer>(data);
        } else {
            TreeNode<Integer> cur;
            if (data <= root.getVal()) {
                cur = insert(root.getLeft(), data);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), data);
                root.setRight(cur);
            }
            return root;
        }
    }
}