package madeeasy.tree;

public class TreeUtil {

    public static TreeNode<Integer> getTestTree() {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        TreeNode<Integer> node9 = new TreeNode<>(9);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
//        node9.setLeft(node10);
        return node1;
    }

    public static void printTree(TreeNode<?> root) {
        String s = "        1\n" +
                "     2     3\n" +
                "  4    5 6    7\n" +
                "8   9";
        System.out.println(s);
    }
}
//        1
//     2     3
//  4    5 6    7
//8   9