package dfs;

public class MaximumDepthOfBinaryTreeRecursive {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node20 = new TreeNode(20, node15, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, node9, node20);


        var m = new MaximumDepthOfBinaryTreeRecursive();
        System.out.println(m.maxDepth(root));
    }


    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
