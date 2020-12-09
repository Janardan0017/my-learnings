package leetcode;

import java.util.Random;

/**
 * Created for interview-preparation on 3/12/20
 */
public class Problem897 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        Random random = new Random(10);
        for(int i=1; i<6; i++){
            insertIntoBST(root, random.nextInt());
        }
        print(root);
    }

    private static TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null)
            root = new TreeNode(val);
        if(val < root.val)
            insertIntoBST(root.left, val);
        else if(val > root.val)
            insertIntoBST(root.right, val);
        return root;
    }

    private static void print(TreeNode root){
        if(root == null)
            return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
}

