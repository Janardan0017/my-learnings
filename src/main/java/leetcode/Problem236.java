package leetcode;

import custom.classess.TreeNode;
import java.util.Stack;

public class Problem236 {

    public static void main(String[] args) {
        Problem236 problem236 = new Problem236();
        // BinaryTree binaryTree = new BinaryTree(Stream.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4).collect(Collectors.toList()));
        // problem236.preOrder(binaryTree.getRoot(), null, null);
//        problem236.lowestCommonAncestor(binaryTree.getRoot(), new TreeNode(5), new TreeNode(1));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> pStack = null;
        Stack<TreeNode> qStack = null;
        stack.push(root);
        while (pStack == null || qStack == null) {
            TreeNode peek = stack.peek();
            if(pStack == null && peek.val == p.val) {
                pStack = new Stack<>();
                pStack.addAll(stack);
            } else if(qStack == null && peek.val == q.val) {
                qStack = new Stack<>();
                qStack.addAll(stack);
            }
            if(peek.left == null && peek.right == null) {
                stack.pop();
            } else if(peek.left != null) {
                stack.push(peek.left);
            } else {
                stack.push(peek.right);
            }
        }
        System.out.println(pStack);
        System.out.println(qStack);
        return root;
    }

    public void preOrder(TreeNode root, Stack<TreeNode> pStack, Stack<TreeNode> qStack) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            System.out.println(peek.val);
            stack.pop();
            if(peek.right != null) {
                stack.push(peek.right);
            }
            if(peek.left != null) {
                stack.push(peek.left);
            }
        }
    }

    public void preOrder2(TreeNode root, Stack<TreeNode> pStack, Stack<TreeNode> qStack) {
        if(root == null) {
            return;
        }
        preOrder(root.left, pStack, qStack);
        preOrder(root.right, pStack, qStack);
    }

}
