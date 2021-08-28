package madeeasy.tree;

import java.util.LinkedList;
import java.util.Random;

public class LevelOrder {

    public static void main(String[] args) {
        Random random = new Random();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node8.setRight(node9);
        node9.setLeft(node10);

        levelOrder(node1);
        System.out.println(getHeight(node1));
    }

    public static void levelOrder(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        linkedList.add(root);
        level.add(0);
        int prevLevel = 0;
        StringBuilder sb = new StringBuilder();
        while (linkedList.size() > 0) {
            TreeNode currentNode = linkedList.poll();
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

    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();
        linkedList.add(root);
        level.add(0);
        int currentLevel = 0;
        while (linkedList.size() > 0) {
            TreeNode currentNode = linkedList.poll();
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

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
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