package binary.search.tree;


public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n4 = new TreeNode(4, null, n5);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n2 = new TreeNode(2, null, n3);

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        minimumDepthOfBinaryTree.minDepth(n2);
        System.out.println(minimumDepthOfBinaryTree.minV);
    }

    int minV = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        visit(root, 1);
        return minV;
    }

    public void visit(TreeNode node, int actualD) {
        if(node == null) {
            return;
        }

        if(node.right == null && node.left == null) {
            minV = Math.min(actualD, minV);
            return;
        }

        visit(node.left, ++actualD);
        visit(node.right, actualD);
    }
}
