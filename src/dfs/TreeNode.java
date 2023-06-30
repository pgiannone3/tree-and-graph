package dfs;

public class TreeNode {

    public final int val;
    public final TreeNode left;
    public final TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.val = value;
        this.left = null;
        this.right = null;
    }
}
