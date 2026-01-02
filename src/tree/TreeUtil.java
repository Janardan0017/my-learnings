package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import customclassess.TreeNode;

public class TreeUtil {

    public static void main(String[] args) {
        TreeNode root = create(List.of(1, 2, 3, 4, 5, 6, 7));
        root.print();
    }

    public static TreeNode<Integer> create(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        int level = validateNodeLength(values);
        TreeNode<Integer> root = new TreeNode<>(values.getFirst());
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        int j = 1;
        List<TreeNode<Integer>> nodes = values.stream()
                .map(v -> v == null ? null : new TreeNode<>(v)).toList();
        while (level > 0) {
            for (int i = q.size(); i > 0; i--) {
                TreeNode<Integer> node = q.poll();
                if (node != null) {
                    node.left = nodes.get(j);
                    node.right = nodes.get(j + 1);
                    q.add(nodes.get(j));
                    q.add(nodes.get(j + 1));
                } else {
                    q.add(null);
                    q.add(null);
                }
                j += 2;
            }
            level--;
        }
        return root;
    }

    private static int validateNodeLength(List<?> list) {
        int level = 0;
        int nodesInLevel = 1;
        while (nodesInLevel < list.size()) {
            level++;
            nodesInLevel = (int) Math.pow(2, level);
        }
        if (nodesInLevel != list.size()) {
            throw new RuntimeException("Invalid length of input to create tree");
        }
        return level + 1;
    }

}
