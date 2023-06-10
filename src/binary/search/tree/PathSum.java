package binary.search.tree;

import java.util.HashSet;
import java.util.Set;

public class PathSum {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4, null, n5);
        TreeNode n3 = new TreeNode(3, n7, n4);
        TreeNode n2 = new TreeNode(2, null, n3);

        PathSum p = new PathSum();
        System.out.println(p.hasPathSum(n2, 12));

        Set<String> a = new HashSet<>();
        a.add("uno");
        a.add("due");
        a.add("tre");
        a.add("quattro");
        Set<String> b = new HashSet<>();

        a.containsAll(b);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return targetSum == 1;
        }

        return visit(root, targetSum, 0);
    }

    private boolean visit(TreeNode treeNode, int targetSum, int actualSum) {
        if(treeNode == null) {
            return false;
        }

        if(treeNode.left == null && treeNode.right == null) {
            return targetSum == (actualSum + treeNode.val);
        }

        actualSum = actualSum + treeNode.val;
        boolean bool1 = visit(treeNode.left, targetSum, actualSum);
        boolean bool2 = visit(treeNode.right, targetSum, actualSum);

        return bool1 || bool2;
    }

    private boolean visit1(TreeNode treeNode, int targetSum) {
        if(treeNode == null) {
            return false;
        }

        if(treeNode.left == null && treeNode.right == null) {
            return targetSum == treeNode.val;
        }

        targetSum = targetSum - treeNode.val;
        boolean bool1 = visit1(treeNode.left, targetSum);
        boolean bool2 = visit1(treeNode.right, targetSum);

        return bool1 || bool2;
    }
}
