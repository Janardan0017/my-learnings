package custom.classess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode<T> {

    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T v) {
        this.val = v;
    }

    public TreeNode(T v, TreeNode<T> left, TreeNode<T> right) {
        this.val = v;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        List<String> lines = new ArrayList<>();
        List<Integer> widths = calculateMaxWidthPerLevel(this);
        printTree(this, 0, 0, widths, lines);
        return String.join("\n", lines);
    }

    // Recursive sideways printer using per-level widths
    void printTree(TreeNode<T> root, int space, int level, List<Integer> widths, List<String> lines) {
        if (root == null) {
            return;
        }

        int width = widths.get(level);
        space += width + 4; // spacing per level

        // print right child first
        printTree(root.right, space, level + 1, widths, lines);

        // print current node padded to width
        lines.add(" ".repeat(space - width - 4) + padLeft(root.val, width));

        // print left child
        printTree(root.left, space, level + 1, widths, lines);
    }

    // Pad string to fixed width, centered
    String padLeft(T s, int width) {
        int pad = width - String.valueOf(s).length();
        return s + " ".repeat(pad);
    }

    // Collect max width per level
    List<Integer> calculateMaxWidthPerLevel(TreeNode<T> root) {
        List<Integer> widths = new ArrayList<>();
        if (root == null) {
            return widths;
        }

        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = 1;
            for (int i = 0; i < size; i++) {
                TreeNode<T> n = q.poll();
                if (n != null) {
                    max = Math.max(max, String.valueOf(n.val).length());
                    q.add(n.left);
                    q.add(n.right);
                }
            }
            widths.add(max);
        }
        return widths;
    }

}
