package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() { }

    public BinaryTree(List<Integer> values) {
        if(values.isEmpty()) {
            return;
        }
        List<TreeNode> levelNodes = new ArrayList<>();
        this.root = new TreeNode(values.get(0));
        levelNodes.add(root);
        int i = 1;
        while (i < values.size()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for(TreeNode node: levelNodes) {
                if(i < values.size() && values.get(i) != null) {
                    TreeNode leftNode = new TreeNode(values.get(i));
                    node.left = leftNode;
                    nextLevelNodes.add(leftNode);
                }
                i++;
                if(i < values.size() && values.get(i) != null) {
                    TreeNode rightNode = new TreeNode(values.get(i));
                    node.right = rightNode;
                    nextLevelNodes.add(rightNode);
                }
                i++;
            }
            levelNodes = nextLevelNodes;
        }
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }
}
