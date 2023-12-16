package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem236 {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        TreeNode treeNode = lowestCommonAncestor(binaryTree.getRoot(), new TreeNode(5), new TreeNode(1));
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, Integer> visitCountMap = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<TreeNode> auxStack = null;
        nodeStack.push(root);
        visitCountMap.put(root.val, 1);
        while (!nodeStack.isEmpty()) {
            TreeNode peekNode = nodeStack.peek();
            if(auxStack == null && (peekNode.val == p.val || peekNode.val == q.val)) {
                auxStack = new Stack<>();
                auxStack.addAll(nodeStack);
            } else if(auxStack != null && (peekNode.val == p.val || peekNode.val == q.val)) {
                break;
            }
            if ((peekNode.left == null && peekNode.right == null) || visitCount(peekNode.val, visitCountMap) == 3) {
                nodeStack.pop();
            } else if (peekNode.left != null && visitCountMap.get(peekNode.left.val) == null) {
                nodeStack.push(peekNode.left);
            } else if (peekNode.right != null && visitCountMap.get(peekNode.right.val) == null) {
                nodeStack.push(peekNode.right);
            }
            if (!nodeStack.isEmpty()) {
                Integer integer = visitCountMap.get(nodeStack.peek().val);
                visitCountMap.put(nodeStack.peek().val, integer == null ? 1 : integer + 1);
            }
        }
        Stack<TreeNode> tempStack = new Stack<>();
        while (!auxStack.isEmpty()) {
            tempStack.push(auxStack.pop());
        }
        while (!nodeStack.isEmpty()) {
            auxStack.push(nodeStack.pop());
        }
        TreeNode peek = null;
        while (!tempStack.isEmpty() && !auxStack.isEmpty() && tempStack.peek().val == auxStack.peek().val) {
            peek = tempStack.pop();
            auxStack.pop();
        }
        return peek;
    }

    public static int visitCount(int val, HashMap<Integer, Integer> countMap) {
        Integer integer = countMap.get(val);
        return integer == null ? 0 : integer;
    }

}
