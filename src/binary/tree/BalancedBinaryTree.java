package binary.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        BalancedBinaryTree b = new BalancedBinaryTree();
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, t9, t20);

        b.isBalanced(root);

    }

    public boolean isBalanced(TreeNode root1) {
        if(root1 == null) {
            return true;
        }

        int N1 = height(root1.left);
        int N2 = height(root1.right);

        if(Math.abs(N1 - N2) >= 2) {
            return false;
        }

        return isBalanced(root1.left) && isBalanced(root1.right);
    }


    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int heightL = height(root.left);
        int heightR = height(root.right);

        return Math.max(heightL, heightR) + 1;
    }


    private static boolean isBalanced(TreeNode N1, int l_N1, TreeNode N2, int l_N2) {
        if(Math.abs(l_N1 - l_N2) > 1) {
            return false;
        }

        if(N1 == null && N2 == null) {
            return true;
        }



        if(N1 == null) {
            return isBalanced(N1, l_N1, N2.right, ++l_N2);
        } else if(N2 == null) {
            return isBalanced(N1.left, l_N1, N2, l_N2);
        } else {
            return isBalanced(N1.left, ++l_N1, N2.right, ++l_N2);
        }
    }
}
