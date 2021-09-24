package madeeasy.tree;

import java.util.Stack;

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

        node5.setRight(node7);
        node5.setLeft(node1);
        node7.setLeft(node6);
        node7.setRight(node9);
        node1.setRight(node3);
//        Random random = new Random();
//        for (int i = 0; i < 5; i++) {
//            node5 = BTree.add(node5, random.nextInt(10));
//        }
        preOrderRecursive(node5);
        System.out.println();
        preOrderNonRecursive(node5);
    }

    public static void preOrderRecursive(TreeNode<Integer> node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }

    public static void preOrderNonRecursive(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<Integer> pop = stack.pop();
            System.out.print(pop.getVal() + " ");
            if (pop.getRight() != null)
                stack.push(pop.getRight());
            if (pop.getLeft() != null)
                stack.push(pop.getRight());
        }
    }
}
