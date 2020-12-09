package madeeasy.tree;

/**
 * Created for interview-preparation on 4/12/20
 */
public interface BTree {

    static TreeNode add(TreeNode root, int val) {
        // if tree has no node then create the root node
        if (root == null)
            return new TreeNode(val);
        TreeNode temp = root;
        while (temp != null) {
            if (val < temp.getVal()) {
                temp = temp.getLeft();
            } else if (val > temp.getVal()) {
                temp = temp.getRight();
            } else {
                break;
            }
        }
        return root;
    }
}
