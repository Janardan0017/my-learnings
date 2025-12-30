package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import custom.classess.TreeNode;

/**
 * Created for interview-preparation on 4/12/20
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        TreeNode<Integer> node3 = new TreeNode<>(3);

        node5.right = (node7);
        node5.left = (node1);
        node7.left = (node6);
        node7.right = (node9);
        node1.right = (node3);
        List<Integer> values = new LinkedList<>();
        preOrderRecursive(node5, values);
        System.out.println(values);
        // preOrderNonRecursive(node5);
    }

    public static void preOrderRecursive(TreeNode<Integer> node, List<Integer> values) {
        if (node != null) {
            System.out.print(node.val + " ");
            values.add(node.val);
            preOrderRecursive(node.left, values);
            preOrderRecursive(node.right, values);
        }
    }

    public static void preOrderNonRecursive(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<Integer> pop = stack.pop();
            System.out.print(pop.val + " ");
            //push the right node before left because you will need that node after popping the left node
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.right);
        }
    }
}
