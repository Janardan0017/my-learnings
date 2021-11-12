package madeeasy.tree;

public class GetTreeHeight {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUtil.getTestTree();
        System.out.println(getHeight(root));
        TreeUtil.printTree(root);
    }

    public static int getHeight(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = getHeight(root.getLeft());
            int rightHeight = getHeight(root.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
